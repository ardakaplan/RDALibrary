package com.ardakaplan.rdalibrary.data.models;

import com.ardakaplan.rdalibrary.data.shared.RDAApplicationVersionCodeSharedProperty;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 18-Aug-20 - 11:24
 * <p>
 * ardakaplan101@gmail.com
 */
@Singleton
public class RDAApplicationOpeningChecker {

    private RDAApplicationVersionCodeSharedProperty RDAApplicationVersionCodeSharedProperty;

    @Inject
    RDAApplicationOpeningChecker(RDAApplicationVersionCodeSharedProperty RDAApplicationVersionCodeSharedProperty) {
        this.RDAApplicationVersionCodeSharedProperty = RDAApplicationVersionCodeSharedProperty;
    }

    public RDAApplicationOpeningType getOpeningType(int currentVersionCode) {

        Integer value = RDAApplicationVersionCodeSharedProperty.getValue();

        RDAApplicationOpeningType rdaApplicationOpeningType;

        if (value == -1) {

            rdaApplicationOpeningType = RDAApplicationOpeningType.NEW_USER;

        } else if (value < currentVersionCode) {

            rdaApplicationOpeningType = RDAApplicationOpeningType.UPDATE;

        } else {

            rdaApplicationOpeningType = RDAApplicationOpeningType.NORMAL;
        }

        RDAApplicationVersionCodeSharedProperty.saveValue(currentVersionCode);

        return rdaApplicationOpeningType;
    }

    public enum RDAApplicationOpeningType {

        NEW_USER,
        UPDATE,
        NORMAL
    }
}
