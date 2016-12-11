package net.intellij.plugins.soy.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class SoyLexer extends FlexAdapter {

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    public SoyLexer() {
        super(new _SoyLexer((Reader) null));
    }

}
