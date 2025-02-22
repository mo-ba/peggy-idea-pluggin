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

public class PeggyActionExpressionImpl extends ASTWrapperPsiElement implements PeggyActionExpression {

  public PeggyActionExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PeggyVisitor visitor) {
    visitor.visitActionExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PeggyVisitor) accept((PeggyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PeggyBoundaries> getBoundariesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyBoundaries.class);
  }

  @Override
  @NotNull
  public List<PeggyCharacterClassMatcher> getCharacterClassMatcherList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyCharacterClassMatcher.class);
  }

  @Override
  @Nullable
  public PeggyCodeBlock getCodeBlock() {
    return findChildByClass(PeggyCodeBlock.class);
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
