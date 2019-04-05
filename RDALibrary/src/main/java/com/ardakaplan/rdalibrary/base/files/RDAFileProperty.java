package com.ardakaplan.rdalibrary.base.files;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

import com.ardakaplan.rdalibrary.base.exceptions.RDAInteractionException;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.File;

/**
 * Created by Arda Kaplan on 05-Apr-19 - 17:07
 */
public abstract class RDAFileProperty {

    protected abstract String getFileName();

    protected abstract String getRootFilePath() throws FileNotCreatedInteractionException;

    public static void scanFile(Context context, File file) {

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
