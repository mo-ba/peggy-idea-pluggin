package com.github.moba.peggyideaplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


class PeggyFileType private constructor() : LanguageFileType(PeggyLanguage) {
    override fun getName(): String {
        return "Peggy Js File"
    }

    override fun getDescription(): String {
        return "Peggy language file"
    }

    override fun getDefaultExtension(): String {
        return "peggy.js"
    }

    override fun getIcon(): Icon {
        println(PeggyIcons.FILE)
        return PeggyIcons.FILE
    }

    companion object {
        val INSTANCE = PeggyFileType()
    }
}
