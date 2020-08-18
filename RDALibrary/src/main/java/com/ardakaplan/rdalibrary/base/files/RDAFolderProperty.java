package com.ardakaplan.rdalibrary.base.files;

import android.os.Environment;

import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.File;

/**
 * Created by Arda Kaplan on 03-Apr-19 - 17:23
 */
public abstract class RDAFolderProperty extends RDAFileProperty {

    public File getFile() throws FileNotCreatedInteractionException {

        StringBuilder path = new StringBuilder();

        if (RDAStringHelpers.isEmpty(getRootFilePath())) {

            //this is root folder
            path.append(Environment.getExternalStorageDirectory());

        } else {

            path.append(getRootFilePath());
        }

        path.append(File.separator);

        path.append(getFileName());

        File file = new File(path.toString());

        if (checkAndCreateFile(file)) {

            return file;

        } else {

            throw new FileNotCreatedInteractionException();
        }
    }

    private boolean checkAndCreateFile(File file) {

        boolean result;

        if (file.exists()) {

            RDALogger.info("File is already exists || path : " + file.getAbsolutePath());

            result = true;

        } else {

            result = file.mkdirs();

            RDALogger.info("File mkdirs result : " + result + " || path : " + file.getAbsolutePath());
        }

        return result;
    }
}
