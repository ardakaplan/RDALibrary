package com.ardakaplan.rdalibrary.helpers;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.exceptions.RDAInteractionException;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan on 03-Apr-19 - 17:23
 */
@Singleton
public class RDAStorageManager {

    private Context context;

    @Inject
    RDAStorageManager(Context context) {
        this.context = context;
    }

    public File createFolder(@Nullable File rootFile, String folderName) throws FileNotCreatedInteractionException {

        StringBuilder path = new StringBuilder();

        path.append(File.separator);

        if (rootFile != null) {

            path.append(rootFile.getAbsolutePath());

            path.append(File.separator);
        } else {

            path.append(Environment.getExternalStorageDirectory());

            path.append(File.separator);
        }

        path.append(folderName);

        File file = new File(path.toString());

        if (checkAndCreateFile(file)) {

            scanFile(file);

            return file;

        } else {

            throw new FileNotCreatedInteractionException();
        }
    }

    public void saveTextFile(File rootFile, String text) throws FileNotCreatedInteractionException {

        File file = new File(Environment.getExternalStorageDirectory() + File.separator + rootFile.getAbsolutePath());

        if (checkAndCreateFile(file)) {


        } else {

            throw new FileNotCreatedInteractionException();
        }
    }

    private boolean checkAndCreateFile(File file) {

        RDALogger.info("Checked file path -> " + file.getAbsolutePath());

        boolean result;

        if (file.exists()) {

            result = true;

        } else {

            result = file.mkdirs();
        }

        RDALogger.info("File create result : " + result + ", with path -> " + file.getAbsolutePath());

        return result;
    }

    private void scanFile(File file) {


        String[] toBeScannedStr = new String[]{file.getAbsolutePath()};

        MediaScannerConnection.scanFile(context, toBeScannedStr, null, new MediaScannerConnection.OnScanCompletedListener() {

            @Override
            public void onScanCompleted(String path, Uri uri) {

                RDALogger.info("FILE SCAN COMPLETED: " + path);
            }
        });
    }

    public static class FileNotCreatedInteractionException extends RDAInteractionException {

    }
}
