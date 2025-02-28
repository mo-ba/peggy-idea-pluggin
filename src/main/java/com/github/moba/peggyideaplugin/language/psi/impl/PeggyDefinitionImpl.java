package com.github.moba.peggyideaplugin.language.psi.impl;

import com.github.moba.peggyideaplugin.language.PeggyReference;
import com.github.moba.peggyideaplugin.language.psi.PeggyDefinition;
import com.github.moba.peggyideaplugin.language.psi.PeggyElementFactory;
import com.github.moba.peggyideaplugin.language.psi.PeggyRuleDefinition;
import com.github.moba.peggyideaplugin.language.psi.PeggyTypes;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PeggyDefinitionImpl extends ASTWrapperPsiElement implements PeggyDefinition {

    public PeggyDefinitionImpl(@NotNull ASTNode node) {
        super(node);
    }


    @Override
    public @Nullable PsiElement getNameIdentifier() {
        ASTNode idNode = getIdNode();
        return idNode != null ? idNode.getPsi() : null;
    }

    @Override
    public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
        ASTNode idNode = getIdNode();
        if (idNode != null) {
            PeggyRuleDefinition property =
                    new PeggyElementFactory().createRuleDefinition(this.getProject(), name);
            ASTNode newIdNode = property.getFirstChild().getNode();
            this.getNode().replaceChild(idNode, newIdNode);
        }
        return this;
    }

    @Nullable
    private ASTNode getIdNode() {
        return this.getNode().findChildByType(PeggyTypes.IDENTIFIER_NAME);
    }

    public String getDefinition() {
        ASTNode idNode = getIdNode();
        if (idNode != null) {
            return idNode.getText();
        } else {
            return null;
        }
    }
    public String getName() {
            return getDefinition();
    }

    @Override
    public PsiReference @NotNull [] getReferences() {
        var ref = new PeggyReference(this, this.getTextRange());
        return new PsiReference[]{ref};
    }
}
