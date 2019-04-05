package com.ardakaplan.rdalibrarytest.ui.filetest;

import android.content.Context;

import com.ardakaplan.rdalibrary.base.files.RDAFolder;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 05-Apr-19 - 17:05
 */
public class ApplicationFolder extends RDAFolder {

    private final String FILE_NAME = "ROOT_FOLDER";

    @Inject
    public ApplicationFolder(Context context) {
        super(context);
    }

    @Override
    public String getFileName() {
        return FILE_NAME;
    }

    @Override
    public String getRootFilePath() {
        return null;
    }

    @Override
    public File getFile() throws FileNotCreatedInteractionException {

        return createFolder();
    }


}
