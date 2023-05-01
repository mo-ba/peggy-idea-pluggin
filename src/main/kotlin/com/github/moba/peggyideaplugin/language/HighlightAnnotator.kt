package com.github.moba.peggyideaplugin.language

import com.github.moba.peggyideaplugin.language.psi.impl.PeggyLabelIdentifierImpl
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.elementType


class HighlightAnnotator : Annotator {
    val highlighter: PeggySyntaxHighlighter = PeggySyntaxHighlighter()

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {

        if (element !is LeafPsiElement) {
            return
        }
        when (element.parent) {
            is PeggyLabelIdentifierImpl -> {
                val range = element.textRange
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(range)
                    .textAttributes(PeggySyntaxHighlighter.LABEL).create()
                return
            }

            else -> {
                println("else e:" + element.elementType + " - p:" + element.parent.elementType)
            }
        }

        //defaults
        val range = element.textRange
        highlighter.getTokenHighlights(element.elementType)
            .iterator()
            .forEach {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(range)
                    .textAttributes(it).create()
            }

        return


    }
}

