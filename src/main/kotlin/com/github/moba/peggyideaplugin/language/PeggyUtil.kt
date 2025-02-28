package com.github.moba.peggyideaplugin.language


import com.github.moba.peggyideaplugin.language.psi.PeggyFile
import com.github.moba.peggyideaplugin.language.psi.PeggyRuleDefinition
import com.google.common.collect.Lists
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import java.util.*


object PeggyUtil {


    /**
     * Searches the entire project for Peggy language files with instances of the Peggy ruleDefinition with the given id.
     *
     * @param project current project
     * @param definition     to check
     * @return matching ruleDefinitions
     */
    fun findRuleDefinitions(project: Project?, definition: String): List<PeggyRuleDefinition> {
        val result: MutableList<PeggyRuleDefinition> = ArrayList<PeggyRuleDefinition>()
        val virtualFiles = FileTypeIndex.getFiles(
            PeggyFileType.INSTANCE, GlobalSearchScope.allScope(
                project!!
            )
        )
        for (virtualFile in virtualFiles) {
            val peggyFile = PsiManager.getInstance(project).findFile(virtualFile!!) as PeggyFile? ?: continue
            val ruleDefinitions = PsiTreeUtil.findChildrenOfType(
                peggyFile,
                PeggyRuleDefinition::class.java
            )
            for (ruleDefinition in ruleDefinitions) {
                if (definition == ruleDefinition.definition) {
                    result.add(ruleDefinition)
                }
            }
        }
        return result
    }

    fun findRuleDefinitions(project: Project?): List<PeggyRuleDefinition> {
        val result: MutableList<PeggyRuleDefinition> = ArrayList<PeggyRuleDefinition>()
        val virtualFiles = FileTypeIndex.getFiles(
            PeggyFileType.INSTANCE, GlobalSearchScope.allScope(
                project!!
            )
        )
        for (virtualFile in virtualFiles) {
            val peggyFile: PeggyFile? = PsiManager.getInstance(project).findFile(virtualFile!!) as PeggyFile?
            if (peggyFile != null) {
                val ruleDefinitions: Array<out PeggyRuleDefinition>? = PsiTreeUtil.getChildrenOfType(
                    peggyFile,
                    PeggyRuleDefinition::class.java
                )
                if (ruleDefinitions != null) {
                    result.addAll(ruleDefinitions)
                }
            }
        }
        return result
    }

    /**
     * Attempts to collect any comment elements above the Peggy definition.
     */
    fun findDocumentationComment(ruleDefinition: PeggyRuleDefinition): String {
        val result: MutableList<String> = LinkedList()
        var element: PsiElement = ruleDefinition.getPrevSibling()
        while (element is PsiComment || element is PsiWhiteSpace) {
            if (element is PsiComment) {
                val commentText = element.getText().replaceFirst("[!# ]+".toRegex(), "")
                result.add(commentText)
            }
            element = element.prevSibling
        }
        return StringUtil.join(Lists.reverse(result), "\n ")
    }
}