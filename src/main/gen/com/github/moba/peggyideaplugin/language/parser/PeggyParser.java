// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.moba.peggyideaplugin.language.psi.PeggyTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PeggyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return peggyFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // SequenceExpression (X__ CodeBlock)?
  static boolean ActionExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ActionExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = SequenceExpression(builder_, level_ + 1);
    result_ = result_ && ActionExpression_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (X__ CodeBlock)?
  private static boolean ActionExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ActionExpression_1")) return false;
    ActionExpression_1_0(builder_, level_ + 1);
    return true;
  }

  // X__ CodeBlock
  private static boolean ActionExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ActionExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = X__(builder_, level_ + 1);
    result_ = result_ && CodeBlock(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // Boundary? X__ OP_RANGE X__ Boundary?
  public static boolean Boundaries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Boundaries")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BOUNDARIES, "<boundaries>");
    result_ = Boundaries_0(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_RANGE);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && Boundaries_4(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // Boundary?
  private static boolean Boundaries_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Boundaries_0")) return false;
    Boundary(builder_, level_ + 1);
    return true;
  }

  // Boundary?
  private static boolean Boundaries_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Boundaries_4")) return false;
    Boundary(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // INTEGER | IDENTIFIER_NAME | CodeBlock
  public static boolean Boundary(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Boundary")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BOUNDARY, "<boundary>");
    result_ = consumeToken(builder_, INTEGER);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER_NAME);
    if (!result_) result_ = CodeBlock(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LEFT_BRACE|RIGHT_BRACE
  public static boolean Brace(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Brace")) return false;
    if (!nextTokenIs(builder_, "<brace>", LEFT_BRACE, RIGHT_BRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BRACE, "<brace>");
    result_ = consumeToken(builder_, LEFT_BRACE);
    if (!result_) result_ = consumeToken(builder_, RIGHT_BRACE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // INTEGER|IDENTIFIER_NAME|COMMENT|WHITE_SPACE|STRING|OPERATOR|PARENTHESIS
  public static boolean Catch(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Catch")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CATCH, "<catch>");
    result_ = consumeToken(builder_, INTEGER);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER_NAME);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, WHITE_SPACE);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = OPERATOR(builder_, level_ + 1);
    if (!result_) result_ = PARENTHESIS(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ActionExpression (X__ OP_OR ActionExpression)* X__
  static boolean ChoiceExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ChoiceExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = ActionExpression(builder_, level_ + 1);
    result_ = result_ && ChoiceExpression_1(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (X__ OP_OR ActionExpression)*
  private static boolean ChoiceExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ChoiceExpression_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!ChoiceExpression_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ChoiceExpression_1", pos_)) break;
    }
    return true;
  }

  // X__ OP_OR ActionExpression
  private static boolean ChoiceExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ChoiceExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = X__(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_OR);
    result_ = result_ && ActionExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ((!Brace CODE_BODY)+ | LEFT_BRACE Code RIGHT_BRACE)*
  public static boolean Code(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code")) return false;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, CODE, "<code>");
    while (true) {
      int pos_ = current_position_(builder_);
      if (!Code_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Code", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // (!Brace CODE_BODY)+ | LEFT_BRACE Code RIGHT_BRACE
  private static boolean Code_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Code_0_0(builder_, level_ + 1);
    if (!result_) result_ = Code_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (!Brace CODE_BODY)+
  private static boolean Code_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Code_0_0_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!Code_0_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Code_0_0", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !Brace CODE_BODY
  private static boolean Code_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Code_0_0_0_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CODE_BODY);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !Brace
  private static boolean Code_0_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !Brace(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // LEFT_BRACE Code RIGHT_BRACE
  private static boolean Code_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LEFT_BRACE);
    result_ = result_ && Code(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_BRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // "{" Code "}"
  public static boolean CodeBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CodeBlock")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CODE_BLOCK, "<code block>");
    result_ = consumeToken(builder_, "{");
    result_ = result_ && Code(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "}");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ChoiceExpression X__
  public static boolean Expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Expression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, EXPRESSION, "<expression>");
    result_ = ChoiceExpression(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // X__ (TopLevelInitializer X__)?  (Initializer X__)? X__ Rule* X__ <<eof>>
  public static boolean Grammar(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GRAMMAR, "<grammar>");
    result_ = X__(builder_, level_ + 1);
    result_ = result_ && Grammar_1(builder_, level_ + 1);
    result_ = result_ && Grammar_2(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && Grammar_4(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && eof(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (TopLevelInitializer X__)?
  private static boolean Grammar_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_1")) return false;
    Grammar_1_0(builder_, level_ + 1);
    return true;
  }

  // TopLevelInitializer X__
  private static boolean Grammar_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = TopLevelInitializer(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (Initializer X__)?
  private static boolean Grammar_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_2")) return false;
    Grammar_2_0(builder_, level_ + 1);
    return true;
  }

  // Initializer X__
  private static boolean Grammar_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Initializer(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // Rule*
  private static boolean Grammar_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_4")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!Rule(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Grammar_4", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // CodeBlock
  public static boolean Initializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Initializer")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, INITIALIZER, "<initializer>");
    result_ = CodeBlock(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LabelIdentifier X__ OP_COLON
  public static boolean LabelColon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabelColon")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LabelIdentifier(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_COLON);
    exit_section_(builder_, marker_, LABEL_COLON, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER_NAME
  public static boolean LabelIdentifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabelIdentifier")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER_NAME);
    exit_section_(builder_, marker_, LABEL_IDENTIFIER, result_);
    return result_;
  }

  /* ********************************************************** */
  // (Pluck LabelColon PrefixedExpression)
  //     | (LabelColon PrefixedExpression)
  //     | (PrefixedExpression)
  static boolean LabeledExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabeledExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LabeledExpression_0(builder_, level_ + 1);
    if (!result_) result_ = LabeledExpression_1(builder_, level_ + 1);
    if (!result_) result_ = LabeledExpression_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // Pluck LabelColon PrefixedExpression
  private static boolean LabeledExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabeledExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Pluck(builder_, level_ + 1);
    result_ = result_ && LabelColon(builder_, level_ + 1);
    result_ = result_ && PrefixedExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LabelColon PrefixedExpression
  private static boolean LabeledExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabeledExpression_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LabelColon(builder_, level_ + 1);
    result_ = result_ && PrefixedExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (PrefixedExpression)
  private static boolean LabeledExpression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabeledExpression_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrefixedExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // STRING "i"?
  public static boolean LiteralMatcher(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LiteralMatcher")) return false;
    if (!nextTokenIs(builder_, STRING)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING);
    result_ = result_ && LiteralMatcher_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, LITERAL_MATCHER, result_);
    return result_;
  }

  // "i"?
  private static boolean LiteralMatcher_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LiteralMatcher_1")) return false;
    consumeToken(builder_, "i");
    return true;
  }

  /* ********************************************************** */
  // OP_EQ|OP_COLON|OP_CHOICE|OP_OPTIONAL|OP_STAR|OP_PLUS|OP_NOT|OP_PLUCK|OP_RANGE
  public static boolean OPERATOR(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "OPERATOR")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPERATOR, "<operator>");
    result_ = consumeToken(builder_, OP_EQ);
    if (!result_) result_ = consumeToken(builder_, OP_COLON);
    if (!result_) result_ = consumeToken(builder_, OP_CHOICE);
    if (!result_) result_ = consumeToken(builder_, OP_OPTIONAL);
    if (!result_) result_ = consumeToken(builder_, OP_STAR);
    if (!result_) result_ = consumeToken(builder_, OP_PLUS);
    if (!result_) result_ = consumeToken(builder_, OP_NOT);
    if (!result_) result_ = consumeToken(builder_, OP_PLUCK);
    if (!result_) result_ = consumeToken(builder_, OP_RANGE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LEFT_PAREN|RIGHT_PAREN
  public static boolean PARENTHESIS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PARENTHESIS")) return false;
    if (!nextTokenIs(builder_, "<parenthesis>", LEFT_PAREN, RIGHT_PAREN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PARENTHESIS, "<parenthesis>");
    result_ = consumeToken(builder_, LEFT_PAREN);
    if (!result_) result_ = consumeToken(builder_, RIGHT_PAREN);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // OP_PLUCK
  public static boolean Pluck(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Pluck")) return false;
    if (!nextTokenIs(builder_, OP_PLUCK)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_PLUCK);
    exit_section_(builder_, marker_, PLUCK, result_);
    return result_;
  }

  /* ********************************************************** */
  // (PrefixedOperator X__ SuffixedExpression)
  //     | SuffixedExpression
  static boolean PrefixedExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrefixedExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrefixedExpression_0(builder_, level_ + 1);
    if (!result_) result_ = SuffixedExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // PrefixedOperator X__ SuffixedExpression
  private static boolean PrefixedExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrefixedExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrefixedOperator(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && SuffixedExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // OP_DOLLAR | OP_AND | OP_NOT
  public static boolean PrefixedOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrefixedOperator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PREFIXED_OPERATOR, "<prefixed operator>");
    result_ = consumeToken(builder_, OP_DOLLAR);
    if (!result_) result_ = consumeToken(builder_, OP_AND);
    if (!result_) result_ = consumeToken(builder_, OP_NOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LiteralMatcher
  // //| CharacterClassMatcher //todo
  // //| AnyMatcher //todo
  // | RuleReferenceExpression
  // | SemanticPredicateExpression
  // | LEFT_PAREN X__ Expression X__ RIGHT_PAREN
  static boolean PrimaryExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrimaryExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LiteralMatcher(builder_, level_ + 1);
    if (!result_) result_ = RuleReferenceExpression(builder_, level_ + 1);
    if (!result_) result_ = SemanticPredicateExpression(builder_, level_ + 1);
    if (!result_) result_ = PrimaryExpression_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LEFT_PAREN X__ Expression X__ RIGHT_PAREN
  private static boolean PrimaryExpression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrimaryExpression_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && Expression(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // PrimaryExpression X__ OP_OR X__ Boundaries X__ (OP_COMMA X__ Expression)
  public static boolean RepeatedExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RepeatedExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REPEATED_EXPRESSION, "<repeated expression>");
    result_ = PrimaryExpression(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_OR);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && Boundaries(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && RepeatedExpression_6(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // OP_COMMA X__ Expression
  private static boolean RepeatedExpression_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RepeatedExpression_6")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COMMA);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && Expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // RuleDefinition X__ OP_EQ X__ Expression
  public static boolean Rule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Rule")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = RuleDefinition(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_EQ);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && Expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, RULE, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER_NAME
  public static boolean RuleDefinition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleDefinition")) return false;
    if (!nextTokenIs(builder_, "<FOO>", IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RULE_DEFINITION, "<FOO>");
    result_ = consumeToken(builder_, IDENTIFIER_NAME);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER_NAME !(X__ (STRING X__)? OP_EQ)
  public static boolean RuleReferenceExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER_NAME);
    result_ = result_ && RuleReferenceExpression_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, RULE_REFERENCE_EXPRESSION, result_);
    return result_;
  }

  // !(X__ (STRING X__)? OP_EQ)
  private static boolean RuleReferenceExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !RuleReferenceExpression_1_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // X__ (STRING X__)? OP_EQ
  private static boolean RuleReferenceExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = X__(builder_, level_ + 1);
    result_ = result_ && RuleReferenceExpression_1_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_EQ);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (STRING X__)?
  private static boolean RuleReferenceExpression_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1_0_1")) return false;
    RuleReferenceExpression_1_0_1_0(builder_, level_ + 1);
    return true;
  }

  // STRING X__
  private static boolean RuleReferenceExpression_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING);
    result_ = result_ && X__(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SemanticPredicateOperator X__ CodeBlock
  public static boolean SemanticPredicateExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SemanticPredicateExpression")) return false;
    if (!nextTokenIs(builder_, "<semantic predicate expression>", OP_AND, OP_NOT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SEMANTIC_PREDICATE_EXPRESSION, "<semantic predicate expression>");
    result_ = SemanticPredicateOperator(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && CodeBlock(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // OP_AND | OP_NOT
  public static boolean SemanticPredicateOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SemanticPredicateOperator")) return false;
    if (!nextTokenIs(builder_, "<semantic predicate operator>", OP_AND, OP_NOT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SEMANTIC_PREDICATE_OPERATOR, "<semantic predicate operator>");
    result_ = consumeToken(builder_, OP_AND);
    if (!result_) result_ = consumeToken(builder_, OP_NOT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LabeledExpression (X__ LabeledExpression)*
  static boolean SequenceExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SequenceExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LabeledExpression(builder_, level_ + 1);
    result_ = result_ && SequenceExpression_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (X__ LabeledExpression)*
  private static boolean SequenceExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SequenceExpression_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!SequenceExpression_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SequenceExpression_1", pos_)) break;
    }
    return true;
  }

  // X__ LabeledExpression
  private static boolean SequenceExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SequenceExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = X__(builder_, level_ + 1);
    result_ = result_ && LabeledExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (PrimaryExpression X__ SuffixedOperator)
  //     | RepeatedExpression
  //     | PrimaryExpression
  static boolean SuffixedExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SuffixedExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = SuffixedExpression_0(builder_, level_ + 1);
    if (!result_) result_ = RepeatedExpression(builder_, level_ + 1);
    if (!result_) result_ = PrimaryExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // PrimaryExpression X__ SuffixedOperator
  private static boolean SuffixedExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SuffixedExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrimaryExpression(builder_, level_ + 1);
    result_ = result_ && X__(builder_, level_ + 1);
    result_ = result_ && SuffixedOperator(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // OP_PLUS | OP_STAR | OP_OPTIONAL
  public static boolean SuffixedOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SuffixedOperator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SUFFIXED_OPERATOR, "<suffixed operator>");
    result_ = consumeToken(builder_, OP_PLUS);
    if (!result_) result_ = consumeToken(builder_, OP_STAR);
    if (!result_) result_ = consumeToken(builder_, OP_OPTIONAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LEFT_BRACE CodeBlock RIGHT_BRACE
  public static boolean TopLevelInitializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TopLevelInitializer")) return false;
    if (!nextTokenIs(builder_, LEFT_BRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LEFT_BRACE);
    result_ = result_ && CodeBlock(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_BRACE);
    exit_section_(builder_, marker_, TOP_LEVEL_INITIALIZER, result_);
    return result_;
  }

  /* ********************************************************** */
  // (COMMENT | WHITE_SPACE)*
  static boolean X__(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "X__")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!X___0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "X__", pos_)) break;
    }
    return true;
  }

  // COMMENT | WHITE_SPACE
  private static boolean X___0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "X___0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, WHITE_SPACE);
    return result_;
  }

  /* ********************************************************** */
  // Grammar
  static boolean peggyFile(PsiBuilder builder_, int level_) {
    return Grammar(builder_, level_ + 1);
  }

}
