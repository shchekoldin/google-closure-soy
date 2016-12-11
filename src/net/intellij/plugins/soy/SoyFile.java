package net.intellij.plugins.soy;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class SoyFile extends PsiFileBase {

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    public SoyFile(FileViewProvider fileViewProvider) {
        super(fileViewProvider, SoySupportLoader.SOY_FILE_TYPE.getLanguage());
    }

    @NotNull
    public FileType getFileType() {
        return SoySupportLoader.SOY_FILE_TYPE;
    }

    public String toString() {
        return "SoyFile: " + getName();
    }

}
