package com.github.moba.peggyideaplugin.language.lexer

import com.intellij.lexer.FlexAdapter

class PeggyLexerAdapter : FlexAdapter(PeggyLexer(null))