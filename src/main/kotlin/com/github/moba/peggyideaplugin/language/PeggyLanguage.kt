package com.github.moba.peggyideaplugin.language

import com.intellij.lang.Language;

class PeggyLanguage : Language("Peggy") {
    companion object {
        @JvmField
        val INSTANCE: PeggyLanguage = PeggyLanguage()
    }
}