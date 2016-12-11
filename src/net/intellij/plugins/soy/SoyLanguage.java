package net.intellij.plugins.soy;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import net.intellij.plugins.soy.highlighter.SoyHighlighter;
import org.jetbrains.annotations.NotNull;

public class SoyLanguage extends Language {

    private static final SoyLanguage instance = new SoyLanguage("soy");

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    public static SoyLanguage getInstance() {
        return instance;
    }

    private SoyLanguage(@NotNull String id) {
        super(id);

        SyntaxHighlighterFactory.LANGUAGE_FACTORY.addExplicitExtension(this, new SingleLazyInstanceSyntaxHighlighterFactory() {

            @NotNull
            @Override
            protected SyntaxHighlighter createHighlighter() {
                return new SoyHighlighter();
            }

        });
    }

    @Override
    public LanguageFileType getAssociatedFileType() {
        return SoyFileType.getInstance();
    }

}
