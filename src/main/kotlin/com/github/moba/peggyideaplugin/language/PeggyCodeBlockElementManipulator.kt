package com.github.moba.peggyideaplugin.language

import com.github.moba.peggyideaplugin.language.psi.PeggyCodeBlock
import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator

class PeggyCodeBlockElementManipulator : AbstractElementManipulator<PeggyCodeBlock>() {
    override fun handleContentChange(element: PeggyCodeBlock, range: TextRange, newContent: String?): PeggyCodeBlock {
        return element;
    }

    override fun handleContentChange(element: PeggyCodeBlock, newContent: String?): PeggyCodeBlock {
        return element;
    }
}