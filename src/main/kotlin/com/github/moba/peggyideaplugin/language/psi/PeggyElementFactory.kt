package com.github.moba.peggyideaplugin.language.psi

import com.github.moba.peggyideaplugin.language.PeggyFileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory


class PeggyElementFactory {
    fun createRuleDefinition(project: Project?, name: String?): PeggyRuleDefinition {
        val file = createFile(project, name)
        return file.firstChild as PeggyRuleDefinition
    }

    fun createFile(project: Project?, text: String?): PeggyFile {
        val name = "dummy.peggy"
        return PsiFileFactory.getInstance(project).createFileFromText(
            name, PeggyFileType.INSTANCE,
            text!!
        ) as PeggyFile
    }
}