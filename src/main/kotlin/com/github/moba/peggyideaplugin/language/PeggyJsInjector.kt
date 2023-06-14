package com.github.moba.peggyideaplugin.language

import com.github.moba.peggyideaplugin.language.psi.PeggyTypes
import com.intellij.lang.Language
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

val params = listOf("location", "text")

class PeggyJsInjector : LanguageInjectionContributor {
    @Nullable
    override fun getInjection(@NotNull context: PsiElement): Injection? {

        return when (context.elementType) {

            PeggyTypes.CODE_BLOCK -> {

                SimpleInjection(
                    Language.findLanguageByID("JavaScript")!!, "((" +
                            params.joinToString(", ") +
                            ")=>", ")", null
                )
            }

            else -> null

        }
    }
}