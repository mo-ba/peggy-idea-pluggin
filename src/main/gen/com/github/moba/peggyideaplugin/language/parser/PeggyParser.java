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
  // Code
  public static boolean BareCodeBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "BareCodeBlock")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BARE_CODE_BLOCK, "<bare code block>");
    result_ = Code(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ((!(LEFT_BRACE|RIGHT_BRACE) CODE_BODY)+ | LEFT_BRACE Code RIGHT_BRACE)*
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

  // (!(LEFT_BRACE|RIGHT_BRACE) CODE_BODY)+ | LEFT_BRACE Code RIGHT_BRACE
  private static boolean Code_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Code_0_0(builder_, level_ + 1);
    if (!result_) result_ = Code_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (!(LEFT_BRACE|RIGHT_BRACE) CODE_BODY)+
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

  // !(LEFT_BRACE|RIGHT_BRACE) CODE_BODY
  private static boolean Code_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = Code_0_0_0_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, CODE_BODY);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !(LEFT_BRACE|RIGHT_BRACE)
  private static boolean Code_0_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !Code_0_0_0_0_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // LEFT_BRACE|RIGHT_BRACE
  private static boolean Code_0_0_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Code_0_0_0_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, LEFT_BRACE);
    if (!result_) result_ = consumeToken(builder_, RIGHT_BRACE);
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
  // "{" BareCodeBlock "}"
  public static boolean CodeBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "CodeBlock")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CODE_BLOCK, "<code block>");
    result_ = consumeToken(builder_, "{");
    result_ = result_ && BareCodeBlock(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "}");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // TopLevelInitializer? Initializer? Rule*
  public static boolean Grammar(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GRAMMAR, "<grammar>");
    result_ = Grammar_0(builder_, level_ + 1);
    result_ = result_ && Grammar_1(builder_, level_ + 1);
    result_ = result_ && Grammar_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // TopLevelInitializer?
  private static boolean Grammar_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_0")) return false;
    TopLevelInitializer(builder_, level_ + 1);
    return true;
  }

  // Initializer?
  private static boolean Grammar_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_1")) return false;
    Initializer(builder_, level_ + 1);
    return true;
  }

  // Rule*
  private static boolean Grammar_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Grammar_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!Rule(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "Grammar_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // CodeBlock EOS
  public static boolean Initializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Initializer")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, INITIALIZER, "<initializer>");
    result_ = CodeBlock(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EOS);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // OP_EQ|OP_COLON|OP_CHOICE|OP_OPTIONAL|OP_STAR|OP_PLUS|OP_NOT|OP_PLUCK
  public static boolean OPERATORS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "OPERATORS")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OPERATORS, "<operators>");
    result_ = consumeToken(builder_, OP_EQ);
    if (!result_) result_ = consumeToken(builder_, OP_COLON);
    if (!result_) result_ = consumeToken(builder_, OP_CHOICE);
    if (!result_) result_ = consumeToken(builder_, OP_OPTIONAL);
    if (!result_) result_ = consumeToken(builder_, OP_STAR);
    if (!result_) result_ = consumeToken(builder_, OP_PLUS);
    if (!result_) result_ = consumeToken(builder_, OP_NOT);
    if (!result_) result_ = consumeToken(builder_, OP_PLUCK);
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
  // INTEGER|IDENTIFIER_NAME|COMMENT|WHITE_SPACE|OPERATORS|PARENTHESIS
  public static boolean Rule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "Rule")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RULE, "<rule>");
    result_ = consumeToken(builder_, INTEGER);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER_NAME);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    if (!result_) result_ = consumeToken(builder_, WHITE_SPACE);
    if (!result_) result_ = OPERATORS(builder_, level_ + 1);
    if (!result_) result_ = PARENTHESIS(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // "{" CodeBlock "}"
  public static boolean TopLevelInitializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TopLevelInitializer")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TOP_LEVEL_INITIALIZER, "<top level initializer>");
    result_ = consumeToken(builder_, "{");
    result_ = result_ && CodeBlock(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "}");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // Grammar
  static boolean peggyFile(PsiBuilder builder_, int level_) {
    return Grammar(builder_, level_ + 1);
  }

}
