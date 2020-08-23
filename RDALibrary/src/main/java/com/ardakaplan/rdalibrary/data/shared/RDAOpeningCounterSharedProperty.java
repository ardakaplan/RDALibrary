package com.ardakaplan.rdalibrary.data.shared;

import com.ardakaplan.rdalibrary.base.RDASharedProperty;
import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 29-Jul-20 - 03:52
 * <p>
 * ardakaplan101@gmail.com
 */
public class RDAOpeningCounterSharedProperty extends RDASharedProperty<Integer> {

    @Inject
    RDAOpeningCounterSharedProperty(RDASharedHelpers rdaSharedHelpers) {
        super(rdaSharedHelpers);
    }

    @Override
    public Integer getDefault() {
        return 0;
    }

    @Override
    public Integer getValue() {
        return getIntegerValue();
    }

    @Override
    protected String getKey() {
        return "APPLICATION_OPENING_COUNT";
    }
}
