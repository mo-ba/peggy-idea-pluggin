package com.github.moba.peggyideaplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


class PeggyFileType private constructor() : LanguageFileType(PeggyLanguage.INSTANCE) {
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
        return PeggyIcons.FILE
    }

    companion object {
        val INSTANCE = PeggyFileType()
    }
}
