// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.moba.peggyideaplugin.language.psi.impl.*;

public interface PeggyTypes {

  IElementType BARE_CODE_BLOCK = new PeggyElementType("BARE_CODE_BLOCK");
  IElementType CODE = new PeggyElementType("CODE");
  IElementType CODE_BLOCK = new PeggyElementType("CODE_BLOCK");
  IElementType GRAMMAR = new PeggyElementType("GRAMMAR");
  IElementType INITIALIZER = new PeggyElementType("INITIALIZER");
  IElementType OPERATORS = new PeggyElementType("OPERATORS");
  IElementType PARENTHESIS = new PeggyElementType("PARENTHESIS");
  IElementType RULE = new PeggyElementType("RULE");
  IElementType TOP_LEVEL_INITIALIZER = new PeggyElementType("TOP_LEVEL_INITIALIZER");

  IElementType CODE_BODY = new PeggyTokenType("CODE_BODY");
  IElementType COMMENT = new PeggyTokenType("COMMENT");
  IElementType EOS = new PeggyTokenType("EOS");
  IElementType IDENTIFIER_NAME = new PeggyTokenType("IDENTIFIER_NAME");
  IElementType INTEGER = new PeggyTokenType("INTEGER");
  IElementType LEFT_BRACE = new PeggyTokenType("LEFT_BRACE");
  IElementType LEFT_PAREN = new PeggyTokenType("LEFT_PAREN");
  IElementType OP_CHOICE = new PeggyTokenType("OP_CHOICE");
  IElementType OP_COLON = new PeggyTokenType("OP_COLON");
  IElementType OP_EQ = new PeggyTokenType("OP_EQ");
  IElementType OP_NOT = new PeggyTokenType("OP_NOT");
  IElementType OP_OPTIONAL = new PeggyTokenType("OP_OPTIONAL");
  IElementType OP_PLUCK = new PeggyTokenType("OP_PLUCK");
  IElementType OP_PLUS = new PeggyTokenType("OP_PLUS");
  IElementType OP_STAR = new PeggyTokenType("OP_STAR");
  IElementType RIGHT_BRACE = new PeggyTokenType("RIGHT_BRACE");
  IElementType RIGHT_PAREN = new PeggyTokenType("RIGHT_PAREN");
  IElementType WHITE_SPACE = new PeggyTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BARE_CODE_BLOCK) {
        return new PeggyBareCodeBlockImpl(node);
      }
      else if (type == CODE) {
        return new PeggyCodeImpl(node);
      }
      else if (type == CODE_BLOCK) {
        return new PeggyCodeBlockImpl(node);
      }
      else if (type == GRAMMAR) {
        return new PeggyGrammarImpl(node);
      }
      else if (type == INITIALIZER) {
        return new PeggyInitializerImpl(node);
      }
      else if (type == OPERATORS) {
        return new PeggyOperatorsImpl(node);
      }
      else if (type == PARENTHESIS) {
        return new PeggyParenthesisImpl(node);
      }
      else if (type == RULE) {
        return new PeggyRuleImpl(node);
      }
      else if (type == TOP_LEVEL_INITIALIZER) {
        return new PeggyTopLevelInitializerImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
