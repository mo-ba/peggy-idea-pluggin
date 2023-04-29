package com.github.moba.peggyideaplugin.language

import com.intellij.lexer.FlexAdapter

class PeggyLexerAdapter : FlexAdapter(PeggyLexer(null))