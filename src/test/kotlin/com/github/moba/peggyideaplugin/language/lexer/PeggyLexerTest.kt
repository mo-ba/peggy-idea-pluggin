package com.github.moba.peggyideaplugin.language.lexer

import com.intellij.lexer.Lexer
import com.intellij.openapi.util.io.FileUtil
import com.intellij.testFramework.LexerTestCase
import java.io.File

abstract class PeggyLexerTest(val path: String) : LexerTestCase() {

//    override fun getName(): String {
//        return "lexingTestData"
//    }

    fun filePath(path: String, extension: String): String {
        return dirPath + "/" + path + "/" + getTestName(true) + extension
    }

    fun runTest(path: String) {
        val expectedFilePath = filePath(path, ".txt")
        val sourceFilePath = filePath(path, ".peggy")
        val expected = FileUtil.loadFile(File(expectedFilePath))
        val source = FileUtil.loadFile(File(sourceFilePath))
        doTest(source, expected)
    }

    fun testLexingTestData() {
        runTest(path)
    }

    override fun createLexer(): Lexer {
        return PeggyLexerAdapter()
    }

    override fun getDirPath(): String {
        return "src/test/testData/lexer"
    }

}

class IdentifierLexerTest : PeggyLexerTest("identifier")
class IntegerLexerTest : PeggyLexerTest("integer")
class CommentLexerTest : PeggyLexerTest("comment")
class WhitespaceLexerTest : PeggyLexerTest("whitespace")
class MultiLineCommentLexerTest : PeggyLexerTest("comment-multi-line")
class CodeBlockLexerTest : PeggyLexerTest("code-block")
class SimpleCodeBlockLexerTest : PeggyLexerTest("code-block-simple")
class DoubleStringLexerTest : PeggyLexerTest("double-string")
class SingleStringLexerTest : PeggyLexerTest("single-string")
class EscapeStringLexerTest : PeggyLexerTest("escape-string") {}
class PrimaryExpressionLexerTest : PeggyLexerTest("expression-primary")
class PluckLexerTest : PeggyLexerTest("pluck")
class CodeBlockRuleLexerTest : PeggyLexerTest("rule-code-block") {}
class TopInitBlockRuleLexerTest : PeggyLexerTest("code-block-top") {}
class SimpleTopInitBlockRuleLexerTest : PeggyLexerTest("init-code-block-simple") {}