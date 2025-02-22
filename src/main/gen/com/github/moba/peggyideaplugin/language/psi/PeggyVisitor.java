// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class PeggyVisitor extends PsiElementVisitor {

  public void visitActionExpression(@NotNull PeggyActionExpression o) {
    visitPsiElement(o);
  }

  public void visitBoundaries(@NotNull PeggyBoundaries o) {
    visitPsiElement(o);
  }

  public void visitBoundary(@NotNull PeggyBoundary o) {
    visitPsiElement(o);
  }

  public void visitBrace(@NotNull PeggyBrace o) {
    visitPsiElement(o);
  }

  public void visitCharacterClassMatcher(@NotNull PeggyCharacterClassMatcher o) {
    visitPsiElement(o);
  }

  public void visitCodeBlock(@NotNull PeggyCodeBlock o) {
    visitCode(o);
  }

  public void visitExpression(@NotNull PeggyExpression o) {
    visitPsiElement(o);
  }

  public void visitInitializer(@NotNull PeggyInitializer o) {
    visitPsiElement(o);
  }

  public void visitLabelColon(@NotNull PeggyLabelColon o) {
    visitPsiElement(o);
  }

  public void visitLabelIdentifier(@NotNull PeggyLabelIdentifier o) {
    visitPsiElement(o);
  }

  public void visitLiteralMatcher(@NotNull PeggyLiteralMatcher o) {
    visitPsiElement(o);
  }

  public void visitPluck(@NotNull PeggyPluck o) {
    visitPsiElement(o);
  }

  public void visitPrefixedOperator(@NotNull PeggyPrefixedOperator o) {
    visitPsiElement(o);
  }

  public void visitRule(@NotNull PeggyRule o) {
    visitPsiElement(o);
  }

  public void visitRuleDefinition(@NotNull PeggyRuleDefinition o) {
    visitDefinition(o);
  }

  public void visitRuleReferenceExpression(@NotNull PeggyRuleReferenceExpression o) {
    visitPsiElement(o);
  }

  public void visitSemanticPredicateExpression(@NotNull PeggySemanticPredicateExpression o) {
    visitPsiElement(o);
  }

  public void visitSemanticPredicateOperator(@NotNull PeggySemanticPredicateOperator o) {
    visitPsiElement(o);
  }

  public void visitSuffixedOperator(@NotNull PeggySuffixedOperator o) {
    visitPsiElement(o);
  }

  public void visitTopLevelInitializer(@NotNull PeggyTopLevelInitializer o) {
    visitPsiElement(o);
  }

  public void visitCode(@NotNull PeggyCode o) {
    visitPsiElement(o);
  }

  public void visitDefinition(@NotNull PeggyDefinition o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
