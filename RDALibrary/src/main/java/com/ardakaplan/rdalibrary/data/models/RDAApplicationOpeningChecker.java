package com.ardakaplan.rdalibrary.data.models;

import com.ardakaplan.rdalibrary.data.shared.ApplicationVersionCodeSharedProperty;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 18-Aug-20 - 11:24
 * <p>
 * ardakaplan101@gmail.com
 */
@Singleton
public class RDAApplicationOpeningChecker {

    private ApplicationVersionCodeSharedProperty applicationVersionCodeSharedProperty;

    @Inject
    RDAApplicationOpeningChecker(ApplicationVersionCodeSharedProperty applicationVersionCodeSharedProperty) {
        this.applicationVersionCodeSharedProperty = applicationVersionCodeSharedProperty;
    }

    public RDAApplicationOpeningType getOpeningType(int currentVersionCode) {

        Integer value = applicationVersionCodeSharedProperty.getValue();

        RDAApplicationOpeningType rdaApplicationOpeningType;

        if (value == -1) {

            rdaApplicationOpeningType = RDAApplicationOpeningType.NEW_USER;

        } else if (value < currentVersionCode) {

            rdaApplicationOpeningType = RDAApplicationOpeningType.UPDATE;

        } else {

            rdaApplicationOpeningType = RDAApplicationOpeningType.NORMAL;
        }

        applicationVersionCodeSharedProperty.saveValue(currentVersionCode);

        return rdaApplicationOpeningType;
    }

    public enum RDAApplicationOpeningType {

        NEW_USER,
        UPDATE,
        NORMAL
    }
}
