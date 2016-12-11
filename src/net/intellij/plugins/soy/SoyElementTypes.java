package net.intellij.plugins.soy;

import com.intellij.lang.Language;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;

public interface SoyElementTypes {

    IFileElementType FILE = new IFileElementType(Language.findInstance(SoyLanguage.class));

    IElementType START_SCRIPT = new SoyElementType("START_SCRIPT");

    IElementType END_SCRIPT = new SoyElementType("END_SCRIPT");

    IElementType START_JAVA_DOC = new SoyElementType("START_JAVA_DOC");

    IElementType END_JAVA_DOC = new SoyElementType("END_JAVA_DOC");

    IElementType JAVA_DOC_PARAM = new SoyElementType("JAVA_DOC_PARAM");

    IElementType NAMESPACE_NAME = new SoyElementType("NAMESPACE_NAME");

    IElementType TEMPLATE_NAME = new SoyElementType("TEMPLATE_NAME");

    IElementType WHITE_SPACE = TokenType.WHITE_SPACE;

    IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

    IElementType KEYWORD = new SoyElementType("KEYWORD");

    IElementType COMMENT = new SoyElementType("COMMENT");

    IElementType VARIABLE = new SoyElementType("VARIABLE");

    IElementType LBRACE = new SoyElementType("LBRACE");

    IElementType RBRACE = new SoyElementType("RBRACE");

    IElementType STRING = new SoyElementType("STRING");

    TokenSet WHITE_SPACES = TokenSet.create(WHITE_SPACE);

    TokenSet COMMENTS = TokenSet.create(COMMENT);

    TokenSet BRACES = TokenSet.create(LBRACE, RBRACE);

}
