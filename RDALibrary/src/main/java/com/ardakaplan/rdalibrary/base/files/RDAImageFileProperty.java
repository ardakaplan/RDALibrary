package com.ardakaplan.rdalibrary.base.files;

import android.graphics.Bitmap;
import android.os.Environment;

import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;

import java.io.File;
import java.io.IOException;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDAImageFileProperty extends RDAFileProperty {

    protected Bitmap bitmap;

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public File createFile() throws RDAFolderProperty.FileNotCreatedInteractionException, IOException {

        File file;

        if (RDAStringHelpers.isEmpty(getRootFilePath())) {


            file = new File(Environment.getExternalStorageDirectory().toString(), getFileName());

        } else {

            file = new File(getRootFilePath(), getFileName());
        }

        creationOfFile(file);

        return file;
    }

    protected abstract void creationOfFile(File file) throws IOException;
}
