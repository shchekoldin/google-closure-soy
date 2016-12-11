package net.intellij.plugins.soy;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

public class SoySupportLoader implements ApplicationComponent {

    public static final LanguageFileType SOY_FILE_TYPE = SoyFileType.getInstance();

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    public void initComponent() {
        ApplicationManager.getApplication().runWriteAction(new Runnable() {

            @Override
            public void run() {
                FileTypeManager.getInstance().associateExtension(SOY_FILE_TYPE, SOY_FILE_TYPE.getDefaultExtension());
            }

        });
    }

    public void disposeComponent() {
    }

    @NotNull
    public String getComponentName() {
        return "SoySupportLoader";
    }

}
