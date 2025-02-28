package com.github.moba.peggyideaplugin.language

import com.github.moba.peggyideaplugin.language.lexer.PeggyLexerAdapter
import com.github.moba.peggyideaplugin.language.psi.PeggyTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as DefaultColors


class PeggySyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return PeggyLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            PeggyTypes.STRING -> STRING_KEYS
            PeggyTypes.CHAR_CLASS -> CHAR_CLASS_KEYS
            PeggyTypes.COMMENT -> COMMENT_KEYS
            PeggyTypes.INTEGER -> INTEGER_KEYS
            PeggyTypes.IDENTIFIER_NAME -> IDENTIFIER_NAME_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val STRING =
            TextAttributesKey.createTextAttributesKey("PEGGY_STRING", DefaultColors.STRING)
        val LABEL =
            TextAttributesKey.createTextAttributesKey("PEGGY_LABEL", DefaultColors.INSTANCE_FIELD)
        val COMMENT =
            TextAttributesKey.createTextAttributesKey("PEGGY_COMMENT", DefaultColors.LINE_COMMENT)
        val INTEGER =
            TextAttributesKey.createTextAttributesKey("PEGGY_INTEGER", DefaultColors.NUMBER)
        val CHAR_CLASS =
            TextAttributesKey.createTextAttributesKey("PEGGY_CHAR_CLASS", DefaultColors.STRING)
        val IDENTIFIER_NAME =
            TextAttributesKey.createTextAttributesKey("PEGGY_IDENTIFIER_NAME", DefaultColors.KEYWORD)
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("PEGGY_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val INTEGER_KEYS = arrayOf(INTEGER)
        private val IDENTIFIER_NAME_KEYS = arrayOf(IDENTIFIER_NAME)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val STRING_KEYS = arrayOf(STRING)
        private val CHAR_CLASS_KEYS = arrayOf(CHAR_CLASS)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}