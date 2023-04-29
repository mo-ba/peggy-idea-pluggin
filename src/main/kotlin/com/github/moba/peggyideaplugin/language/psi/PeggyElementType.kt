package com.github.moba.peggyideaplugin.language.psi

import com.github.moba.peggyideaplugin.language.PeggyLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls


class PeggyElementType(debugName: @NonNls String) :
    IElementType(debugName, PeggyLanguage.INSTANCE)