package com.ardakaplan.rdalibrarytest.managers.storage;

import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan on 14-Dec-18 - 17:29
 */
@Singleton
public class SharedManager {

    private final String USERNAME = "USERNAME";

    private RDASharedHelpers rdaSharedHelpers;

    @Inject
    SharedManager(RDASharedHelpers rdaSharedHelpers) {

        this.rdaSharedHelpers = rdaSharedHelpers;
    }

    public void saveUsername(String username) {

        rdaSharedHelpers.putString(USERNAME, username);
    }

    public String getUsername() {

        return rdaSharedHelpers.getString(USERNAME, "");
    }
}
