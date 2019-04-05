package com.ardakaplan.rdalibrarytest.ui.filetest.data;

import com.ardakaplan.rdalibrary.base.files.RDATextFileProperty;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public class TestTextProperty extends RDATextFileProperty {

    @Inject
    InnerFolder innerFolder;

    @Inject
    public TestTextProperty() {
    }

    @Override
    protected String getFileName() {
        return "TEST.txt";
    }

    @Override
    protected String getRootFilePath() throws FileNotCreatedInteractionException {

        return innerFolder.getFile().getAbsolutePath();
    }
}
