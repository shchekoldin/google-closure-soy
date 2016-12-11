package net.intellij.plugins.soy.parser;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import net.intellij.plugins.soy.SoyElementTypes;
import net.intellij.plugins.soy.SoyFile;
import net.intellij.plugins.soy.lexer.SoyLexer;
import org.jetbrains.annotations.NotNull;

public class SoyParserDefinition implements ParserDefinition {

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    @NotNull
    public Lexer createLexer(Project project) {
        return new SoyLexer();
    }

    public PsiParser createParser(Project project) {
        return new SoyParser();
    }

    public IFileElementType getFileNodeType() {
        return SoyElementTypes.FILE;
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return SoyElementTypes.WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return SoyElementTypes.COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return new TokenSet();
    }

    @NotNull
    public PsiElement createElement(ASTNode astNode) {
        return new ASTWrapperPsiElement(astNode);
    }

    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new SoyFile(fileViewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MUST;
    }
    
}
