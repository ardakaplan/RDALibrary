package com.ardakaplan.rdalibrarytest.ui.filetest.data;

import com.ardakaplan.rdalibrary.base.files.RDAFolderProperty;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public class InnerFolder extends RDAFolderProperty {

    private ApplicationFolder applicationFolder;

    @Inject
    InnerFolder(ApplicationFolder applicationFolder) {
        this.applicationFolder = applicationFolder;
    }

    @Override
    protected String getFileName() {
        return "INNER_FOLDER";
    }

    @Override
    protected String getRootFilePath() throws FileNotCreatedInteractionException {

        return applicationFolder.getFile().getAbsolutePath();
    }
}
