package com.github.moba.peggyideaplugin.language


import com.github.moba.peggyideaplugin.language.lexer.PeggyLexerAdapter
import com.github.moba.peggyideaplugin.language.psi.PeggyRuleDefinition
import com.github.moba.peggyideaplugin.language.psi.PeggyRuleReferenceExpression
import com.github.moba.peggyideaplugin.language.psi.PeggyTokenSets
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.TokenSet

internal class SimpleFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            PeggyLexerAdapter(),
            PeggyTokenSets.IDENTIFIER,
            PeggyTokenSets.COMMENT,
            TokenSet.EMPTY
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is PsiNamedElement
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        return when (element) {
            is PeggyRuleDefinition -> "PeggyRuleDefinition"
            is PeggyRuleReferenceExpression -> "PeggyRuleReferenceExpression"
            else -> ""
        }
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return when (element) {
            is PeggyRuleDefinition -> element.definition
            else -> ""
        }
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        val x =  when (element) {
            is PeggyRuleDefinition -> (element).nameIdentifier?.text.orEmpty()
            else -> ""
        }
        return x
    }
}