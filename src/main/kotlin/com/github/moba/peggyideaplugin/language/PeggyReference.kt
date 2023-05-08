package com.github.moba.peggyideaplugin.language


import com.github.moba.peggyideaplugin.language.psi.PeggyRuleDefinition
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*


class PeggyReference(element: PsiElement, textRange: TextRange) :
    PsiReferenceBase<PsiElement?>(element, textRange), PsiPolyVariantReference {
    private val key: String

    init {
        key = element.text
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement!!.project
        val properties: List<PeggyRuleDefinition> = PeggyUtil.findRuleDefinitions(project, key)
        val results: MutableList<ResolveResult> = ArrayList()
        for (property in properties) {
            results.add(PsiElementResolveResult(property))
        }
        return results.toTypedArray<ResolveResult>()
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun getVariants(): Array<Any> {
        val project = myElement!!.project
        val properties: List<PeggyRuleDefinition> = PeggyUtil.findRuleDefinitions(project)
        val variants: MutableList<LookupElement> = ArrayList()
        for (property in properties) {
            if (property.definition != null && property.definition.isNotEmpty()) {
                variants.add(
                    LookupElementBuilder
                        .create(property).withIcon(PeggyIcons.FILE)
                        .withTypeText(property.containingFile.name)
                )
            }
        }
        return variants.toTypedArray()
    }
}