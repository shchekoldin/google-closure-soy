package net.intellij.plugins.soy;

import com.intellij.psi.tree.IElementType;

public class SoyElementType extends IElementType {

    // -------------------------------------------------------
    // -                        LOGIC                        -
    // -------------------------------------------------------

    public SoyElementType(String debugName) {
        super(debugName, SoySupportLoader.SOY_FILE_TYPE.getLanguage());
    }

}
