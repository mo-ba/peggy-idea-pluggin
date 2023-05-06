// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.moba.peggyideaplugin.language.psi.impl.*;

public interface PeggyTypes {

  IElementType ACTION_EXPRESSION = new PeggyElementType("ACTION_EXPRESSION");
  IElementType BOUNDARIES = new PeggyElementType("BOUNDARIES");
  IElementType BOUNDARY = new PeggyElementType("BOUNDARY");
  IElementType BRACE = new PeggyElementType("BRACE");
  IElementType CODE_BLOCK = new PeggyElementType("CODE_BLOCK");
  IElementType EXPRESSION = new PeggyElementType("EXPRESSION");
  IElementType GRAMMAR = new PeggyElementType("GRAMMAR");
  IElementType INITIALIZER = new PeggyElementType("INITIALIZER");
  IElementType LABEL_COLON = new PeggyElementType("LABEL_COLON");
  IElementType LABEL_IDENTIFIER = new PeggyElementType("LABEL_IDENTIFIER");
  IElementType LITERAL_MATCHER = new PeggyElementType("LITERAL_MATCHER");
  IElementType PLUCK = new PeggyElementType("PLUCK");
  IElementType PREFIXED_OPERATOR = new PeggyElementType("PREFIXED_OPERATOR");
  IElementType RULE = new PeggyElementType("RULE");
  IElementType RULE_DEFINITION = new PeggyElementType("RULE_DEFINITION");
  IElementType RULE_REFERENCE_EXPRESSION = new PeggyElementType("RULE_REFERENCE_EXPRESSION");
  IElementType SEMANTIC_PREDICATE_EXPRESSION = new PeggyElementType("SEMANTIC_PREDICATE_EXPRESSION");
  IElementType SEMANTIC_PREDICATE_OPERATOR = new PeggyElementType("SEMANTIC_PREDICATE_OPERATOR");
  IElementType SUFFIXED_OPERATOR = new PeggyElementType("SUFFIXED_OPERATOR");
  IElementType TOP_LEVEL_INITIALIZER = new PeggyElementType("TOP_LEVEL_INITIALIZER");
  IElementType X = new PeggyElementType("X");

  IElementType CODE_BODY = new PeggyTokenType("CODE_BODY");
  IElementType COMMENT = new PeggyTokenType("COMMENT");
  IElementType IDENTIFIER_NAME = new PeggyTokenType("IDENTIFIER_NAME");
  IElementType INIT_CODE = new PeggyTokenType("INIT_CODE");
  IElementType INTEGER = new PeggyTokenType("INTEGER");
  IElementType LEFT_BRACE = new PeggyTokenType("LEFT_BRACE");
  IElementType LEFT_PAREN = new PeggyTokenType("LEFT_PAREN");
  IElementType OP_AND = new PeggyTokenType("OP_AND");
  IElementType OP_CHOICE = new PeggyTokenType("OP_CHOICE");
  IElementType OP_COLON = new PeggyTokenType("OP_COLON");
  IElementType OP_COMMA = new PeggyTokenType("OP_COMMA");
  IElementType OP_DOLLAR = new PeggyTokenType("OP_DOLLAR");
  IElementType OP_EQ = new PeggyTokenType("OP_EQ");
  IElementType OP_NOT = new PeggyTokenType("OP_NOT");
  IElementType OP_OPTIONAL = new PeggyTokenType("OP_OPTIONAL");
  IElementType OP_OR = new PeggyTokenType("OP_OR");
  IElementType OP_PLUCK = new PeggyTokenType("OP_PLUCK");
  IElementType OP_PLUS = new PeggyTokenType("OP_PLUS");
  IElementType OP_RANGE = new PeggyTokenType("OP_RANGE");
  IElementType OP_STAR = new PeggyTokenType("OP_STAR");
  IElementType RIGHT_BRACE = new PeggyTokenType("RIGHT_BRACE");
  IElementType RIGHT_PAREN = new PeggyTokenType("RIGHT_PAREN");
  IElementType STRING = new PeggyTokenType("STRING");
  IElementType WHITE_SPACE = new PeggyTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACTION_EXPRESSION) {
        return new PeggyActionExpressionImpl(node);
      }
      else if (type == BOUNDARIES) {
        return new PeggyBoundariesImpl(node);
      }
      else if (type == BOUNDARY) {
        return new PeggyBoundaryImpl(node);
      }
      else if (type == BRACE) {
        return new PeggyBraceImpl(node);
      }
      else if (type == CODE_BLOCK) {
        return new PeggyCodeBlockImpl(node);
      }
      else if (type == EXPRESSION) {
        return new PeggyExpressionImpl(node);
      }
      else if (type == GRAMMAR) {
        return new PeggyGrammarImpl(node);
      }
      else if (type == INITIALIZER) {
        return new PeggyInitializerImpl(node);
      }
      else if (type == LABEL_COLON) {
        return new PeggyLabelColonImpl(node);
      }
      else if (type == LABEL_IDENTIFIER) {
        return new PeggyLabelIdentifierImpl(node);
      }
      else if (type == LITERAL_MATCHER) {
        return new PeggyLiteralMatcherImpl(node);
      }
      else if (type == PLUCK) {
        return new PeggyPluckImpl(node);
      }
      else if (type == PREFIXED_OPERATOR) {
        return new PeggyPrefixedOperatorImpl(node);
      }
      else if (type == RULE) {
        return new PeggyRuleImpl(node);
      }
      else if (type == RULE_DEFINITION) {
        return new PeggyRuleDefinitionImpl(node);
      }
      else if (type == RULE_REFERENCE_EXPRESSION) {
        return new PeggyRuleReferenceExpressionImpl(node);
      }
      else if (type == SEMANTIC_PREDICATE_EXPRESSION) {
        return new PeggySemanticPredicateExpressionImpl(node);
      }
      else if (type == SEMANTIC_PREDICATE_OPERATOR) {
        return new PeggySemanticPredicateOperatorImpl(node);
      }
      else if (type == SUFFIXED_OPERATOR) {
        return new PeggySuffixedOperatorImpl(node);
      }
      else if (type == TOP_LEVEL_INITIALIZER) {
        return new PeggyTopLevelInitializerImpl(node);
      }
      else if (type == X) {
        return new PeggyXImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
