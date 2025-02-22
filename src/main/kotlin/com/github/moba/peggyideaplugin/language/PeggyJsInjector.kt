package com.github.moba.peggyideaplugin.language

import com.github.moba.peggyideaplugin.language.psi.PeggyFile
import com.github.moba.peggyideaplugin.language.psi.PeggyInitializer
import com.github.moba.peggyideaplugin.language.psi.PeggyTopLevelInitializer
import com.github.moba.peggyideaplugin.language.psi.PeggyTypes
import com.intellij.lang.Language
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

typealias Decl = Pair<String, String>

val definitions: List<String> = listOf(
    "/**\n" +
            " * @typedef {Object} PeggyPosition\n" +
            " * @property {number} offset\n" +
            " * @property {number} line\n" +
            " * @property {number} column\n" +
            " */",
    "/**\n" +
            " * @typedef {Object} PeggyLocation\n" +
            " * @property {PeggyPosition} start\n" +
            " * @property {PeggyPosition} end\n" +
            " */"
)

val declarations: List<Decl> = listOf(
    Pair(
        "location",
        "{function: {start:{offset:number,line:number,column:number},end:{offset:number,line:number,column:number}}}"
    ),
    Pair("text", "{function: string}")
)

val JavaScript = Language.findLanguageByID("JavaScript")!!

class PeggyJsInjector : LanguageInjectionContributor {
    @Nullable
    override fun getInjection(@NotNull context: PsiElement): Injection? {


        return when (context.elementType) {

            PeggyTypes.CODE_BLOCK -> {
                val prefix = buildPrefix(context)
                SimpleInjection(
                    JavaScript,
                    prefix,
                    "\n);",
                    null
                )
            }
            else -> null
        }
    }
}

fun getRoot(context: PsiElement): PsiElement {
    var element = context
    while (element !is PeggyFile) {
        element = element.parent
    }
    return element;
}

fun getInitializer(context: PsiElement?, offset:Int): String{
    return context?.text?.let { text -> text.substring(offset, text.length-offset) }.orEmpty()+";"
}

fun buildPrefix(context: PsiElement): String {
    val labels = getLabels(context)
    val root= getRoot(context)
    val topLevelInitializer = root.children.find { it is PeggyTopLevelInitializer }
    val initializer = root.children.find { it is PeggyInitializer }
    return listOf(
        getInitializer(topLevelInitializer,2),
        getInitializer(initializer,1),
        getDefinitions(),
        getDeclarations(),
        "(function (${getParamString(labels)})\n"
    ).joinToString("\n\n")
}

fun getDefinitions(): String {
    return definitions.joinToString("\n")
}

fun getParamString(labels: List<String>): String {
    return labels.joinToString(", ")
}

fun getDeclarations(): String {
    return declarations.joinToString("\n\n") { getDeclaration(it) }
}

fun getDeclaration(decl: Decl): String {
    return listOf(
        "/**",
        " * @type ${decl.second}",
        " */",
        "const ${decl.first} = ${decl.first}"
    ).joinToString("\n")
}

fun getLabels(context: PsiElement): List<String> {

    return context
        .parent
        .children
        .filter { it.elementType == PeggyTypes.LABEL_COLON }
        .map { it.firstChild.text }
}