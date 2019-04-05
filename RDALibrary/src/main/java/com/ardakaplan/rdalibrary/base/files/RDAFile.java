package com.ardakaplan.rdalibrary.base.files;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;

import com.ardakaplan.rdalibrary.base.exceptions.RDAInteractionException;
import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.File;

/**
 * Created by Arda Kaplan on 05-Apr-19 - 17:07
 */
public abstract class RDAFile {

    protected abstract String getFileName();

    protected abstract String getRootFilePath();

    public abstract File getFile() throws FileNotCreatedInteractionException;

    private Context context;

    RDAFile(Context context) {
        this.context = context;
    }

    protected File createFolder() throws FileNotCreatedInteractionException {

        StringBuilder path = new StringBuilder();

        if (RDAStringHelpers.isEmpty(getRootFilePath())) {

            //this is root folder
            path.append(Environment.getExternalStorageDirectory());

            path.append(File.separator);

        } else {

            path.append(getRootFilePath());

            path.append(File.separator);

        }

        path.append(getFileName());

        File file = new File(path.toString());

        if (checkAndCreateFile(file)) {

            scanFile(file);

            return file;

        } else {

            throw new FileNotCreatedInteractionException();
        }

    }

//    protected void saveTextFile(File rootFile, String text) throws RDAFolder.FileNotCreatedInteractionException {
//
//        File file = new File(Environment.getExternalStorageDirectory() + File.separator + rootFile.getAbsolutePath());
//
//        if (checkAndCreateFile(file)) {
//
//
//        } else {
//
//            throw new RDAFolder.FileNotCreatedInteractionException();
//        }
//    }

    protected boolean checkAndCreateFile(File file) {

        RDALogger.info("Checked file path -> " + file.getAbsolutePath());

        boolean result;

        if (file.exists()) {

            RDALogger.info("File is already exists - path -> " + file.getAbsolutePath());

            result = true;

        } else {

            result = file.mkdirs();

            RDALogger.info("File create result : " + result + " - path -> " + file.getAbsolutePath());
        }

        return result;
    }

    protected void scanFile(File file) {

        String[] toBeScannedStr = new String[]{file.getAbsolutePath()};

        MediaScannerConnection.scanFile(context, toBeScannedStr, null, new MediaScannerConnection.OnScanCompletedListener() {

            @Override
            public void onScanCompleted(String path, Uri uri) {

                RDALogger.info("File scan completed : " + path);
            }
        });
    }

    public class FileNotCreatedInteractionException extends RDAInteractionException {

    }
}
