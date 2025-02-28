package com.github.moba.peggyideaplugin.language.psi

import com.intellij.psi.tree.TokenSet


interface PeggyTokenSets {
    companion object {
        val WHITE_SPACE = TokenSet.create(PeggyTypes.WHITE_SPACE)
        val IDENTIFIER = TokenSet.create(PeggyTypes.IDENTIFIER_NAME)
        val COMMENT = TokenSet.create(PeggyTypes.COMMENT)
    }
}