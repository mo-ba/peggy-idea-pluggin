package com.github.moba.peggyideaplugin.language


import com.github.moba.peggyideaplugin.language.psi.PeggyFile
import com.github.moba.peggyideaplugin.language.psi.PeggyRuleDefinition
import com.github.moba.peggyideaplugin.language.psi.PeggyRuleReferenceExpression
import com.github.moba.peggyideaplugin.language.psi.PeggyTypes
import com.github.moba.peggyideaplugin.language.psi.impl.PeggyLabelIdentifierImpl
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.SyntaxTraverser
import com.intellij.util.ProcessingContext
import java.util.*


class PeggyCompletionContributor : CompletionContributor() {


    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(PeggyTypes.IDENTIFIER_NAME),
            object : CompletionProvider<CompletionParameters>() {
                public override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {

                    val position = parameters.position
                    val parent = position.parent
                    val file = parameters.originalFile as PeggyFile

                    when (parent) {
                        is PeggyRuleReferenceExpression -> {
                            val rules = calcRules(file)
                            rules.values.forEach { resultSet.addElement(LookupElementBuilder.create(it)) }
                        }

                        is PeggyFile -> {

                            resultSet.addElement(LookupElementBuilder.create("FILE"))
                        }

                        is PeggyLabelIdentifierImpl -> {
                            val ref = parent.parent.nextSibling
                            val child = ref?.firstChild
                            if (child != null) {
                                val recommendations = buildRecommendations(child.text)

                                recommendations.forEach { resultSet.addElement(LookupElementBuilder.create(it)) }

                            }
                        }

                        else -> {
                           //do nothing
                            val x = 0;
                        }
                    }

                }
            }
        )
    }



    private fun buildRecommendations(text: String?): List<String> {
        val recommendations = mutableListOf<String>()
        if (text == null) {
            return recommendations
        }
        val parts = text.split(Regex("(?=\\p{Upper})"))

        var aggregate = ""
        for (part in parts) {
            aggregate += part
            recommendations.add(aggregate.replaceFirstChar { it.lowercase(Locale.getDefault()) })
        }




        return recommendations.filter { it.isNotEmpty() }
    }


    private fun calcRules(root: PsiElement): Map<String, PeggyRuleDefinition> {
        val result: MutableMap<String, PeggyRuleDefinition> = LinkedHashMap()
        val traverser = SyntaxTraverser.psiTraverser().withRoot(root)

        for (o in traverser.filter(PeggyRuleDefinition::class.java)) {
            if (!result.containsKey(o.name)) {
                result[o.name.toString()] = o
            }
        }
        return result
    }
}