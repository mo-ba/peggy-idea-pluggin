package com.github.moba.peggyideaplugin.language


import com.github.moba.peggyideaplugin.language.parser.PeggyParser
import com.github.moba.peggyideaplugin.language.psi.PeggyFile
import com.github.moba.peggyideaplugin.language.psi.PeggyTokenSets
import com.github.moba.peggyideaplugin.language.psi.PeggyTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


class PeggyParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return PeggyLexerAdapter()
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return PeggyParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return PeggyFile(viewProvider)
    }

    override fun createElement(node: ASTNode): PsiElement {
        return PeggyTypes.Factory.createElement(node)
    }

    companion object {
        val FILE = IFileElementType(PeggyLanguage)
    }
}