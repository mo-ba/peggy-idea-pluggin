package com.github.moba.peggyideaplugin.language.parser

import com.github.moba.peggyideaplugin.language.PeggyParserDefinition
import com.intellij.testFramework.ParsingTestCase


abstract class CommonParsingTestCase(path: String) : ParsingTestCase(path, "peggy", PeggyParserDefinition()) {

    internal constructor() : this("comment")

    fun testParsingTestData() {
        doTest(true)
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    override fun getTestDataPath(): String {
        return "src/test/testData/parser"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}

class CommentParsingTest : CommonParsingTestCase("comment") {}
//class InitialCodeParsingTest : CommonParsingTestCase("initialCode") {}