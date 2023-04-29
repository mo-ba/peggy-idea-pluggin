package com.github.moba.peggyideaplugin.language.psi


import com.github.moba.peggyideaplugin.language.PeggyFileType
import com.github.moba.peggyideaplugin.language.PeggyLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider


class PeggyFile(viewProvider: FileViewProvider) :
    PsiFileBase(viewProvider, PeggyLanguage) {
    override fun getFileType(): FileType {
        return PeggyFileType.INSTANCE
    }

    override fun toString(): String {
        return "Peggy File"
    }
}