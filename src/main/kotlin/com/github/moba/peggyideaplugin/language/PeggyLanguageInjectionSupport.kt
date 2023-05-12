package com.github.moba.peggyideaplugin.language

import com.intellij.patterns.PlatformPatterns
import org.intellij.plugins.intelliLang.inject.AbstractLanguageInjectionSupport

class PeggyLanguageInjectionSupport: AbstractLanguageInjectionSupport() {
    override fun getId(): String {
       return PeggyLanguage.INSTANCE.id
    }

    override fun getPatternClasses(): Array<Class<*>> {
        return arrayOf(PlatformPatterns::class.java);
    }
}