package com.ardakaplan.rdalibrarytest.ui.filetest.data;

import android.graphics.Bitmap;

import com.ardakaplan.rdalibrary.base.files.RDAFileProperty;
import com.ardakaplan.rdalibrary.base.files.RDAImageFileProperty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 26-May-20 - 02:04
 * <p>
 * ardakaplan101@gmail.com
 */
public class WeddingCounterImageFileProperty extends RDAImageFileProperty {

    private InnerFolder innerFolder;

    @Inject
    public WeddingCounterImageFileProperty(InnerFolder innerFolder) {
        this.innerFolder = innerFolder;
    }

    @Override
    protected String getFileName() {
        return "MY_WEDDING_" + System.currentTimeMillis() + ".png";
    }

    @Override
    protected String getRootFilePath() throws RDAFileProperty.FileNotCreatedInteractionException {
        return innerFolder.getFile().getAbsolutePath();
    }

    @Override
    protected void creationOfFile(File file) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);

        fileOutputStream.close();

    }
}
