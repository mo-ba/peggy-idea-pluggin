// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.moba.peggyideaplugin.language.psi.PeggyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.moba.peggyideaplugin.language.psi.*;

public class PeggyExpressionImpl extends ASTWrapperPsiElement implements PeggyExpression {

  public PeggyExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PeggyVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PeggyVisitor) accept((PeggyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PeggyCodeBlock> getCodeBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyCodeBlock.class);
  }

  @Override
  @NotNull
  public List<PeggyExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyExpression.class);
  }

  @Override
  @NotNull
  public List<PeggyLabelColon> getLabelColonList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyLabelColon.class);
  }

  @Override
  @NotNull
  public List<PeggyLiteralMatcher> getLiteralMatcherList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyLiteralMatcher.class);
  }

  @Override
  @NotNull
  public List<PeggyPluck> getPluckList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyPluck.class);
  }

  @Override
  @NotNull
  public List<PeggyPrefixedOperator> getPrefixedOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyPrefixedOperator.class);
  }

  @Override
  @NotNull
  public List<PeggyRepeatedExpression> getRepeatedExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyRepeatedExpression.class);
  }

  @Override
  @NotNull
  public List<PeggyRuleReferenceExpression> getRuleReferenceExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyRuleReferenceExpression.class);
  }

  @Override
  @NotNull
  public List<PeggySemanticPredicateExpression> getSemanticPredicateExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggySemanticPredicateExpression.class);
  }

  @Override
  @NotNull
  public List<PeggySuffixedOperator> getSuffixedOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggySuffixedOperator.class);
  }

}
