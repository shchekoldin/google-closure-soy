package net.intellij.plugins.soy.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import net.intellij.plugins.soy.SoyElementTypes;
import net.intellij.plugins.soy.lexer.SoyLexer;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SoyHighlighter extends SyntaxHighlighterBase {

    private static Map<IElementType, TextAttributesKey> keys;

    private static final TextAttributesKey SOY_VARIABLE = TextAttributesKey.createTextAttributesKey(
        "SOY.VARIABLE",
        new TextAttributes(new Color(69 ,131, 131), null, null, null, Font.PLAIN));

    private static final TextAttributesKey SOY_NAMESPACE_NAME = TextAttributesKey.createTextAttributesKey(
        "SOY.NAMESPACE_NAME",
        new TextAttributes(new Color(69 ,131, 131), null, new Color(69 ,131, 131), EffectType.LINE_UNDERSCORE, Font.BOLD));

    private static final TextAttributesKey SOY_TEMPLATE_NAME = TextAttributesKey.createTextAttributesKey(
        "SOY.TEMPLATE_NAME",
        new TextAttributes(new Color(69 ,131, 131), null, new Color(69 ,131, 131), EffectType.LINE_UNDERSCORE, Font.BOLD));

    private static final TextAttributesKey SOY_JAVA_DOC_PARAM = TextAttributesKey.createTextAttributesKey(
        "SOY.JAVA_DOC_PARAM",
        new TextAttributes(new Color(69 ,131, 131), null, new Color(69 ,131, 131), EffectType.LINE_UNDERSCORE, Font.PLAIN));

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    static {
        keys = new HashMap<IElementType, TextAttributesKey>();

        SyntaxHighlighterBase.fillMap(keys, SoyElementTypes.COMMENTS, SyntaxHighlighterColors.JAVA_BLOCK_COMMENT);
        fillMap(keys, SoyElementTypes.BRACES, SyntaxHighlighterColors.BRACES);

        keys.put(SoyElementTypes.NAMESPACE_NAME, SOY_NAMESPACE_NAME);
        keys.put(SoyElementTypes.TEMPLATE_NAME, SOY_TEMPLATE_NAME);
        keys.put(SoyElementTypes.JAVA_DOC_PARAM, SOY_JAVA_DOC_PARAM);
        keys.put(SoyElementTypes.VARIABLE, SOY_VARIABLE);
        keys.put(SoyElementTypes.KEYWORD, SyntaxHighlighterColors.KEYWORD);
        keys.put(SoyElementTypes.STRING, SyntaxHighlighterColors.STRING);
    }

    @NotNull
    public Lexer getHighlightingLexer() {
        return new SoyLexer();
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(keys.get(tokenType));
    }

}
