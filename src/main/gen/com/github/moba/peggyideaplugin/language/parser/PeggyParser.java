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
    return PeggyFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // SequenceExpression (Skip CodeBlock)?
  public static boolean ActionExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ActionExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ACTION_EXPRESSION, "<action expression>");
    result_ = SequenceExpression(builder_, level_ + 1);
    result_ = result_ && ActionExpression_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (Skip CodeBlock)?
  private static boolean ActionExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ActionExpression_1")) return false;
    ActionExpression_1_0(builder_, level_ + 1);
    return true;
  }

  // Skip CodeBlock
  private static boolean ActionExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ActionExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Skip(builder_, level_ + 1);
    result_ = result_ && CodeBlock(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // Boundary? Skip OP_RANGE Skip Boundary?
  public static boolean Boundaries(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Boundaries")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BOUNDARIES, "<boundaries>");
    result_ = Boundaries_0(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_RANGE);
    result_ = result_ && Skip(builder_, level_ + 1);
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
  // CHAR_CLASS
  public static boolean CharacterClassMatcher(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CharacterClassMatcher")) return false;
    if (!nextTokenIs(builder_, CHAR_CLASS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CHAR_CLASS);
    exit_section_(builder_, marker_, CHARACTER_CLASS_MATCHER, result_);
    return result_;
  }

  /* ********************************************************** */
  // ActionExpression (Skip OP_CHOICE ActionExpression)* Skip
  static boolean ChoiceExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ChoiceExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = ActionExpression(builder_, level_ + 1);
    result_ = result_ && ChoiceExpression_1(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (Skip OP_CHOICE ActionExpression)*
  private static boolean ChoiceExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ChoiceExpression_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!ChoiceExpression_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ChoiceExpression_1", pos_)) break;
    }
    return true;
  }

  // Skip OP_CHOICE ActionExpression
  private static boolean ChoiceExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ChoiceExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Skip(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_CHOICE);
    result_ = result_ && ActionExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // CODE_BODY
  public static boolean CodeBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CodeBlock")) return false;
    if (!nextTokenIs(builder_, CODE_BODY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CODE_BODY);
    exit_section_(builder_, marker_, CODE_BLOCK, result_);
    return result_;
  }

  /* ********************************************************** */
  // ChoiceExpression
  public static boolean Expression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Expression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EXPRESSION, "<expression>");
    result_ = ChoiceExpression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // CodeBlock
  public static boolean Initializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Initializer")) return false;
    if (!nextTokenIs(builder_, CODE_BODY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = CodeBlock(builder_, level_ + 1);
    exit_section_(builder_, marker_, INITIALIZER, result_);
    return result_;
  }

  /* ********************************************************** */
  // LabelIdentifier Skip OP_COLON
  public static boolean LabelColon(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabelColon")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LabelIdentifier(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
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
  // Pluck? LabelColon? PrefixedExpression
  static boolean LabeledExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabeledExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LabeledExpression_0(builder_, level_ + 1);
    result_ = result_ && LabeledExpression_1(builder_, level_ + 1);
    result_ = result_ && PrefixedExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // Pluck?
  private static boolean LabeledExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabeledExpression_0")) return false;
    Pluck(builder_, level_ + 1);
    return true;
  }

  // LabelColon?
  private static boolean LabeledExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "LabeledExpression_1")) return false;
    LabelColon(builder_, level_ + 1);
    return true;
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
  // Skip (TopLevelInitializer Skip)?  (Initializer Skip)? (Rule Skip)*
  static boolean PeggyFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PeggyFile")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Skip(builder_, level_ + 1);
    result_ = result_ && PeggyFile_1(builder_, level_ + 1);
    result_ = result_ && PeggyFile_2(builder_, level_ + 1);
    result_ = result_ && PeggyFile_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (TopLevelInitializer Skip)?
  private static boolean PeggyFile_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PeggyFile_1")) return false;
    PeggyFile_1_0(builder_, level_ + 1);
    return true;
  }

  // TopLevelInitializer Skip
  private static boolean PeggyFile_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PeggyFile_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = TopLevelInitializer(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (Initializer Skip)?
  private static boolean PeggyFile_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PeggyFile_2")) return false;
    PeggyFile_2_0(builder_, level_ + 1);
    return true;
  }

  // Initializer Skip
  private static boolean PeggyFile_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PeggyFile_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Initializer(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (Rule Skip)*
  private static boolean PeggyFile_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PeggyFile_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!PeggyFile_3_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "PeggyFile_3", pos_)) break;
    }
    return true;
  }

  // Rule Skip
  private static boolean PeggyFile_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PeggyFile_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Rule(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
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
  // (PrefixedOperator Skip SuffixedExpression) | SuffixedExpression
  static boolean PrefixedExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrefixedExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrefixedExpression_0(builder_, level_ + 1);
    if (!result_) result_ = SuffixedExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // PrefixedOperator Skip SuffixedExpression
  private static boolean PrefixedExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrefixedExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrefixedOperator(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
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
  // LEFT_PAREN Skip Expression Skip RIGHT_PAREN
  //     | LiteralMatcher
  //     | RuleReferenceExpression
  //     | SemanticPredicateExpression
  //     | ANY_MATCHER
  //     | CharacterClassMatcher
  static boolean PrimaryExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrimaryExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrimaryExpression_0(builder_, level_ + 1);
    if (!result_) result_ = LiteralMatcher(builder_, level_ + 1);
    if (!result_) result_ = RuleReferenceExpression(builder_, level_ + 1);
    if (!result_) result_ = SemanticPredicateExpression(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, ANY_MATCHER);
    if (!result_) result_ = CharacterClassMatcher(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LEFT_PAREN Skip Expression Skip RIGHT_PAREN
  private static boolean PrimaryExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "PrimaryExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && Expression(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // PrimaryExpression Skip OP_OR Skip Boundaries Skip (OP_COMMA Skip Expression)
  static boolean RepeatedExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RepeatedExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrimaryExpression(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_OR);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && Boundaries(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && RepeatedExpression_6(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // OP_COMMA Skip Expression
  private static boolean RepeatedExpression_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RepeatedExpression_6")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COMMA);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && Expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // RuleDefinition Skip (STRING Skip)? OP_EQ Skip Expression
  public static boolean Rule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Rule")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = RuleDefinition(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && Rule_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_EQ);
    result_ = result_ && Skip(builder_, level_ + 1);
    result_ = result_ && Expression(builder_, level_ + 1);
    exit_section_(builder_, marker_, RULE, result_);
    return result_;
  }

  // (STRING Skip)?
  private static boolean Rule_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Rule_2")) return false;
    Rule_2_0(builder_, level_ + 1);
    return true;
  }

  // STRING Skip
  private static boolean Rule_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Rule_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING);
    result_ = result_ && Skip(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER_NAME
  public static boolean RuleDefinition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleDefinition")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER_NAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER_NAME);
    exit_section_(builder_, marker_, RULE_DEFINITION, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER_NAME !(Skip (STRING Skip)? OP_EQ)
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

  // !(Skip (STRING Skip)? OP_EQ)
  private static boolean RuleReferenceExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !RuleReferenceExpression_1_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // Skip (STRING Skip)? OP_EQ
  private static boolean RuleReferenceExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Skip(builder_, level_ + 1);
    result_ = result_ && RuleReferenceExpression_1_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_EQ);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (STRING Skip)?
  private static boolean RuleReferenceExpression_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1_0_1")) return false;
    RuleReferenceExpression_1_0_1_0(builder_, level_ + 1);
    return true;
  }

  // STRING Skip
  private static boolean RuleReferenceExpression_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RuleReferenceExpression_1_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING);
    result_ = result_ && Skip(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SemanticPredicateOperator Skip CodeBlock
  public static boolean SemanticPredicateExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SemanticPredicateExpression")) return false;
    if (!nextTokenIs(builder_, "<semantic predicate expression>", OP_AND, OP_NOT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SEMANTIC_PREDICATE_EXPRESSION, "<semantic predicate expression>");
    result_ = SemanticPredicateOperator(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
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
  // LabeledExpression (Skip LabeledExpression)*
  static boolean SequenceExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SequenceExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = LabeledExpression(builder_, level_ + 1);
    result_ = result_ && SequenceExpression_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (Skip LabeledExpression)*
  private static boolean SequenceExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SequenceExpression_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!SequenceExpression_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SequenceExpression_1", pos_)) break;
    }
    return true;
  }

  // Skip LabeledExpression
  private static boolean SequenceExpression_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SequenceExpression_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Skip(builder_, level_ + 1);
    result_ = result_ && LabeledExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (COMMENT | WHITE_SPACE)*
  static boolean Skip(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Skip")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!Skip_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Skip", pos_)) break;
    }
    return true;
  }

  // COMMENT | WHITE_SPACE
  private static boolean Skip_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Skip_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, WHITE_SPACE);
    return result_;
  }

  /* ********************************************************** */
  // (PrimaryExpression Skip SuffixedOperator) | RepeatedExpression | PrimaryExpression
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

  // PrimaryExpression Skip SuffixedOperator
  private static boolean SuffixedExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SuffixedExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = PrimaryExpression(builder_, level_ + 1);
    result_ = result_ && Skip(builder_, level_ + 1);
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

}
