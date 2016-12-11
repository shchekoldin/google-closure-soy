package net.intellij.plugins.soy;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SoyFileType extends LanguageFileType {

    private static final SoyFileType instance = new SoyFileType(SoyLanguage.getInstance());

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    public static SoyFileType getInstance() {
        return instance;
    }

    private SoyFileType(@NotNull Language language) {
        super(language);
    }

    @NotNull
    public String getName() {
        return "Soy";
    }

    @NotNull
    public String getDescription() {
        return "Google Closure Soy Templates Language";
    }

    @NotNull
    public String getDefaultExtension() {
        return "soy";
    }

    public Icon getIcon() {
        return IconLoader.getIcon("/net/intellij/plugins/soy/resources/icon.png");
    }

}
