package com.ardakaplan.rdalibrary.base.files;

import android.os.Environment;

import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDATextFileProperty extends RDAFileProperty {

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public File createFile() throws RDAFolderProperty.FileNotCreatedInteractionException, IOException {

        File file;

        if (RDAStringHelpers.isEmpty(getRootFilePath())) {


            file = new File(Environment.getExternalStorageDirectory().toString(), getFileName());

        } else {

            file = new File(getRootFilePath(), getFileName());
        }

        try (FileOutputStream stream = new FileOutputStream(file)) {

            stream.write(text.getBytes());

            return file;
        }
    }


}
