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

public class PeggyGrammarImpl extends ASTWrapperPsiElement implements PeggyGrammar {

  public PeggyGrammarImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PeggyVisitor visitor) {
    visitor.visitGrammar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PeggyVisitor) accept((PeggyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PeggyInitializer getInitializer() {
    return findChildByClass(PeggyInitializer.class);
  }

  @Override
  @NotNull
  public List<PeggyRule> getRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PeggyRule.class);
  }

  @Override
  @Nullable
  public PeggyTopLevelInitializer getTopLevelInitializer() {
    return findChildByClass(PeggyTopLevelInitializer.class);
  }

}
