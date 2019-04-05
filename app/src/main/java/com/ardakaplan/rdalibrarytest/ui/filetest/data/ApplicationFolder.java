package com.ardakaplan.rdalibrarytest.ui.filetest.data;

import com.ardakaplan.rdalibrary.base.files.RDAFolderProperty;

import java.io.File;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan on 05-Apr-19 - 17:05
 */
public class ApplicationFolder extends RDAFolderProperty {

    @Inject
    public ApplicationFolder() {
    }

    @Override
    public String getFileName() {
        return "RDA_LIB_FOLDER";
    }

    @Override
    public String getRootFilePath() {
        return null;
    }

}
