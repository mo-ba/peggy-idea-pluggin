package com.github.moba.peggyideaplugin.language

import com.github.moba.peggyideaplugin.language.psi.PeggyTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as DefaultColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType


class PeggySyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return PeggyLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            PeggyTypes.COMMENT -> COMMENT_KEYS
            PeggyTypes.INTEGER -> INTEGER_KEYS
            PeggyTypes.IDENTIFIER_NAME -> IDENTIFIER_NAME_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val COMMENT =
            TextAttributesKey.createTextAttributesKey("PEGGY_COMMENT", DefaultColors.LINE_COMMENT)
        val INTEGER =
            TextAttributesKey.createTextAttributesKey("PEGGY_INTEGER", DefaultColors.NUMBER)
        val IDENTIFIER_NAME =
            TextAttributesKey.createTextAttributesKey("PEGGY_IDENTIFIER_NAME", DefaultColors.IDENTIFIER)
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("PEGGY_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val INTEGER_KEYS = arrayOf(INTEGER)
        private val IDENTIFIER_NAME_KEYS = arrayOf(IDENTIFIER_NAME)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}