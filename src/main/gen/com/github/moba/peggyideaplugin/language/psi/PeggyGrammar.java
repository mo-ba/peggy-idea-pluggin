// This is a generated file. Not intended for manual editing.
package com.github.moba.peggyideaplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PeggyGrammar extends PsiElement {

  @Nullable
  PeggyInitializer getInitializer();

  @NotNull
  List<PeggyRule> getRuleList();

  @Nullable
  PeggyTopLevelInitializer getTopLevelInitializer();

}
