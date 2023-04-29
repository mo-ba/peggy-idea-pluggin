// Peggy Grammar
// ==============
//
// Peggy grammar syntax is designed to be simple, expressive, and similar to
// JavaScript where possible. This means that many rules, especially in the
// lexical part, are based on the grammar from ECMA-262, 5.1 Edition [1]. Some
// are directly taken or adapted from the JavaScript example grammar (see
// examples/javascript.pegjs).
//
// Limitations:
//
//   * Non-BMP characters are completely ignored to avoid surrogate pair
//     handling.
//
//   * One can create identifiers containing illegal characters using Unicode
//     escape sequences. For example, "abcd\u0020efgh" is not a valid
//     identifier, but it is accepted by the parser.
//
// Both limitations could be resolved, but the costs would likely outweigh
// the benefits.
//
// [1] http://www.ecma-international.org/publications/standards/Ecma-262.htm

{{
  const OPS_TO_PREFIXED_TYPES = {
    "$": "text",
    "&": "simple_and",
    "!": "simple_not"
  };

  const OPS_TO_SUFFIXED_TYPES = {
    "?": "optional",
    "*": "zero_or_more",
    "+": "one_or_more"
  };

  const OPS_TO_SEMANTIC_PREDICATE_TYPES = {
    "&": "semantic_and",
    "!": "semantic_not"
  };
}}
{
  // Cannot use Set here because of native IE support.
  const reservedWords = options.reservedWords || [];
}
// ---- Syntactic Grammar -----

Grammar
  = __ topLevelInitializer:(@TopLevelInitializer __)? initializer:(@Initializer __)? rules:(@Rule __)+ {
      return {
        type: "grammar",
        topLevelInitializer,
        initializer,
        rules,
        location: location()
      };
    }

TopLevelInitializer
  = "{" code:CodeBlock "}" EOS {
      return {
        type: "top_level_initializer",
        code: code[0],
        codeLocation: code[1],
        location: location()
      };
    }

Initializer
  = code:CodeBlock EOS {
      return {
        type: "initializer",
        code: code[0],
        codeLocation: code[1],
        location: location()
      };
    }

Rule
  = name:IdentifierName __
    displayName:(@StringLiteral __)?
    "=" __
    expression:Expression EOS
    {
      return {
        type: "rule",
        name: name[0],
        nameLocation: name[1],
        expression: displayName !== null
          ? {
              type: "named",
              name: displayName,
              expression,
              location: location()
            }
          : expression,
        location: location()
      };
    }

Expression
  = ChoiceExpression

ChoiceExpression
  = head:ActionExpression tail:(__ "/" __ @ActionExpression)* {
      return tail.length > 0
        ? {
            type: "choice",
            alternatives: [head].concat(tail),
            location: location()
          }
        : head;
    }

ActionExpression
  = expression:SequenceExpression code:(__ @CodeBlock)? {
      return code !== null
        ? {
            type: "action",
            expression,
            code: code[0],
            codeLocation: code[1],
            location: location()
          }
        : expression;
    }

SequenceExpression
  = head:LabeledExpression tail:(__ @LabeledExpression)* {
      return ((tail.length > 0) || (head.type === "labeled" && head.pick))
        ? {
            type: "sequence",
            elements: [head].concat(tail),
            location: location()
          }
        : head;
    }

LabeledExpression
  = pluck:Pluck label:LabelColon? expression:PrefixedExpression {
      if (expression.type.startsWith("semantic_")) {
        error("\"@\" cannot be used on a semantic predicate", pluck);
      }
      return {
        type: "labeled",
        label: label !== null ? label[0] : null,
        // Use location of "@" if label is unavailable
        labelLocation: label !== null ? label[1] : pluck,
        pick: true,
        expression,
        location: location()
      };
    }
  / label:LabelColon __ expression:PrefixedExpression {
      return {
        type: "labeled",
        label: label[0],
        labelLocation: label[1],
        expression,
        location: location()
      };
    }
  / PrefixedExpression

Pluck
  = "@" { return location(); }

LabelColon
  = label:IdentifierName __ ":" {
      if (reservedWords.indexOf(label[0]) >= 0) {
        error(`Label can't be a reserved word "${label[0]}"`, label[1]);
      }

      return label;
    }

PrefixedExpression
  = operator:PrefixedOperator __ expression:SuffixedExpression {
      return {
        type: OPS_TO_PREFIXED_TYPES[operator],
        expression,
        location: location()
      };
    }
  / SuffixedExpression

PrefixedOperator
  = "$"
  / "&"
  / "!"

SuffixedExpression
  = expression:PrimaryExpression __ operator:SuffixedOperator {
      return {
        type: OPS_TO_SUFFIXED_TYPES[operator],
        expression,
        location: location()
      };
    }
  / RepeatedExpression
  / PrimaryExpression

SuffixedOperator
  = "?"
  / "*"
  / "+"

RepeatedExpression
  = expression:PrimaryExpression __ "|" __ boundaries:Boundaries __ delimiter:("," __ @Expression __)? "|" {
      let min = boundaries[0];
      let max = boundaries[1];
      if (max.type === "constant" && max.value === 0) {
        error("The maximum count of repetitions of the rule must be > 0", max.location);
      }

      return {
        type: "repeated",
        min,
        max,
        expression,
        delimiter,
        location: location(),
      };
    }

Boundaries
  = min:Boundary? __ ".." __ max:Boundary? {
    return [
      min !== null ? min : { type: "constant", value: 0 },
      max !== null ? max : { type: "constant", value: null },
    ];
  }
  / exact:Boundary { return [null, exact]; }

Boundary
  = value:Integer { return { type: "constant", value, location: location() }; }
  / value:IdentifierName { return { type: "variable", value: value[0], location: location() }; }
  / value:CodeBlock {
    return {
      type: "function",
      value: value[0],
      codeLocation: value[1],
      location: location(),
    };
  }

PrimaryExpression
  = LiteralMatcher
  / CharacterClassMatcher
  / AnyMatcher
  / RuleReferenceExpression
  / SemanticPredicateExpression
  / "(" __ expression:Expression __ ")" {
      // The purpose of the "group" AST node is just to isolate label scope. We
      // don't need to put it around nodes that can't contain any labels or
      // nodes that already isolate label scope themselves. This leaves us with
      // "labeled" and "sequence".
      return expression.type === "labeled" || expression.type === "sequence"
          ? { type: "group", expression, location: location() }
          : expression;
    }

RuleReferenceExpression
  = name:IdentifierName !(__ (StringLiteral __)? "=") {
      return { type: "rule_ref", name: name[0], location: location() };
    }

SemanticPredicateExpression
  = operator:SemanticPredicateOperator __ code:CodeBlock {
      return {
        type: OPS_TO_SEMANTIC_PREDICATE_TYPES[operator],
        code: code[0],
        codeLocation: code[1],
        location: location()
      };
    }

SemanticPredicateOperator
  = "&"
  / "!"



//-------------------------------------------------
//-------------------------------------------------

LiteralMatcher "literal"
  = StringLiteral ignoreCase:"i"? {
      return {
        type: "literal",
        value,
        ignoreCase: ignoreCase !== null,
        location: location()
      };
    }

StringLiteral "string"
  = '"' chars:DoubleStringCharacter* '"' { return chars.join(""); }
  / "'" chars:SingleStringCharacter* "'" { return chars.join(""); }

DoubleStringCharacter
  = $(!('"' / "\\" / LineTerminator) SourceCharacter)
  / "\\" @EscapeSequence
  / LineContinuation

SingleStringCharacter
  = $(!("'" / "\\" / LineTerminator) SourceCharacter)
  / "\\" @EscapeSequence
  / LineContinuation

CharacterClassMatcher "character class"
  = "["
    inverted:"^"?
    parts:(ClassCharacterRange / ClassCharacter)*
    "]"
    ignoreCase:"i"?
    {
      return {
        type: "class",
        parts: parts.filter(part => part !== ""),
        inverted: inverted !== null,
        ignoreCase: ignoreCase !== null,
        location: location()
      };
    }

ClassCharacterRange
  = begin:ClassCharacter "-" end:ClassCharacter {
      if (begin.charCodeAt(0) > end.charCodeAt(0)) {
        error(
          "Invalid character range: " + text() + "."
        );
      }

      return [begin, end];
    }

ClassCharacter
  = $(!("]" / "\\" / LineTerminator) SourceCharacter)
  / "\\" @EscapeSequence
  / LineContinuation

LineContinuation
  = "\\" LineTerminatorSequence { return ""; }

EscapeSequence
  = CharacterEscapeSequence
  / "0" !DecimalDigit { return "\0"; }
  / HexEscapeSequence
  / UnicodeEscapeSequence

CharacterEscapeSequence
  = SingleEscapeCharacter
  / NonEscapeCharacter

SingleEscapeCharacter
  = "'"
  / '"'
  / "\\"
  / "b"  { return "\b"; }
  / "f"  { return "\f"; }
  / "n"  { return "\n"; }
  / "r"  { return "\r"; }
  / "t"  { return "\t"; }
  / "v"  { return "\v"; }

NonEscapeCharacter
  = $(!(EscapeCharacter / LineTerminator) SourceCharacter)

EscapeCharacter
  = SingleEscapeCharacter
  / DecimalDigit
  / "x"
  / "u"

HexEscapeSequence
  = "x" digits:$(HexDigit HexDigit) {
      return String.fromCharCode(parseInt(digits, 16));
    }

UnicodeEscapeSequence
  = "u" digits:$(HexDigit HexDigit HexDigit HexDigit) {
      return String.fromCharCode(parseInt(digits, 16));
    }



AnyMatcher
  = "." { return { type: "any", location: location() }; }

CodeBlock "code block"
  = "{" @BareCodeBlock "}"

BareCodeBlock
  = code:Code { return [code, location()]; }

Code
  = $((![{}] SourceCharacter)+ / "{" Code "}")*





//-------------------------------------------------
//-------------------------------------------------







// Skipped

__
  = (WhiteSpace / LineTerminatorSequence / Comment)*

_
  = (WhiteSpace / MultiLineCommentNoLineTerminator)*

// Automatic Semicolon Insertion

EOS
  = (__ ";")+
  / _ SingleLineComment? LineTerminatorSequence
  / __ EOF

EOF
  = !.



