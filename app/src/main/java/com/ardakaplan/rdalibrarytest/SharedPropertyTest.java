package com.ardakaplan.rdalibrarytest;

import com.ardakaplan.rdalibrary.RDASharedProperty;
import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan on 05-Feb-19 - 15:56
 */
@Singleton
public class SharedPropertyTest extends RDASharedProperty<String> {

    @Inject
    public SharedPropertyTest(RDASharedHelpers rdaSharedHelpers) {
        super(rdaSharedHelpers);
    }

    @Override
    public String getDefault() {
        return "DEFAULT";
    }
}
