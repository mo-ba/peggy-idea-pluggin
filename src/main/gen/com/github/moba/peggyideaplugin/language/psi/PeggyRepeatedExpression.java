// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PeggyRepeatedExpression extends PsiElement {

  @NotNull
  PeggyBoundaries getBoundaries();

  @NotNull
  List<PeggyExpression> getExpressionList();

  @Nullable
  PeggyLiteralMatcher getLiteralMatcher();

  @Nullable
  PeggyRuleReferenceExpression getRuleReferenceExpression();

  @Nullable
  PeggySemanticPredicateExpression getSemanticPredicateExpression();

}
