package com.github.moba.peggyideaplugin.language


import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

internal class SimpleReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        println("registerReferenceProviders")
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement<PsiLiteralExpression>(
                PsiLiteralExpression::class.java
            ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    println("PsiReferenceProvider")
                    val literalExpression = element as PsiLiteralExpression
                    val value = if (literalExpression.value is String) literalExpression.value as String? else null
                    if ((value != null && value.startsWith(HighlightAnnotator.PEGGY_PREFIX_STR + HighlightAnnotator.PEGGY_SEPARATOR_STR))) {
                        val property = TextRange(
                            HighlightAnnotator.PEGGY_PREFIX_STR.length + HighlightAnnotator.PEGGY_SEPARATOR_STR.length + 1,
                            value.length + 1
                        )
                        return arrayOf(PeggyReference(element, property))
                    }
                    return PsiReference.EMPTY_ARRAY
                }
            })
    }
}