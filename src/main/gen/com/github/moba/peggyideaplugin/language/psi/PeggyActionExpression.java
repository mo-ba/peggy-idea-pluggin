// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PeggyActionExpression extends PsiElement {

  @NotNull
  List<PeggyBoundaries> getBoundariesList();

  @NotNull
  List<PeggyCharacterClassMatcher> getCharacterClassMatcherList();

  @Nullable
  PeggyCodeBlock getCodeBlock();

  @NotNull
  List<PeggyExpression> getExpressionList();

  @NotNull
  List<PeggyLabelColon> getLabelColonList();

  @NotNull
  List<PeggyLiteralMatcher> getLiteralMatcherList();

  @NotNull
  List<PeggyPluck> getPluckList();

  @NotNull
  List<PeggyPrefixedOperator> getPrefixedOperatorList();

  @NotNull
  List<PeggyRuleReferenceExpression> getRuleReferenceExpressionList();

  @NotNull
  List<PeggySemanticPredicateExpression> getSemanticPredicateExpressionList();

  @NotNull
  List<PeggySuffixedOperator> getSuffixedOperatorList();

}
