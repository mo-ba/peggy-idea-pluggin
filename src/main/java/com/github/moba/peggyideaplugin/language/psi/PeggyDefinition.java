package com.github.moba.peggyideaplugin.language.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PeggyDefinition extends PsiElement, PsiNameIdentifierOwner {
    String getDefinition();

}
