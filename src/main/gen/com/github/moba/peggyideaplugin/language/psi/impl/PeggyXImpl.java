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

public class PeggyXImpl extends ASTWrapperPsiElement implements PeggyX {

  public PeggyXImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PeggyVisitor visitor) {
    visitor.visitX(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PeggyVisitor) accept((PeggyVisitor)visitor);
    else super.accept(visitor);
  }

}
