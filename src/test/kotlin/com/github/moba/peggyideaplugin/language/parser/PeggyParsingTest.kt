package com.github.moba.peggyideaplugin.language.parser

import com.github.moba.peggyideaplugin.language.PeggyParserDefinition
import com.intellij.testFramework.ParsingTestCase


abstract class CommonParsingTestCase(path: String) : ParsingTestCase(path, "peggy", PeggyParserDefinition()) {

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
class TopLevelInitializerParsingTest : CommonParsingTestCase("topLevelInitializer") {}
class InitializerParsingTest : CommonParsingTestCase("initializer") {}
class SimpleRuleParsingTest : CommonParsingTestCase("rule-simple") {}
class SimpleRule2ParsingTest : CommonParsingTestCase("rule-simple2") {}
class PluckRuleParsingTest : CommonParsingTestCase("rule-with-pluck") {}
class CodeBlockRuleParsingTest : CommonParsingTestCase("rule-code-block") {}