package com.ardakaplan.rdalibrarytest.sharedtest;

import com.ardakaplan.rdalibrary.base.RDASharedProperty;
import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan on 05-Feb-19 - 15:56
 */
@Singleton
public class SharedPropertyTest extends RDASharedProperty<String> {

    @Inject
    SharedPropertyTest(RDASharedHelpers rdaSharedHelpers) {
        super(rdaSharedHelpers);
    }

    @Override
    public String getDefault() {
        return "DEFAULT";
    }

    @Override
    public String getValue() {
        return getStringValue();
    }
}
