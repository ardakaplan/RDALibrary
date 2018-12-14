package com.ardakaplan.rdalibrarytest.managers.storage;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan on 14-Dec-18 - 17:34
 */
@Singleton
public class StorageManager {

    private SharedManager sharedManager;

    @Inject
    StorageManager(SharedManager sharedManager) {
        this.sharedManager = sharedManager;
    }

    public SharedManager getSharedManager() {
        return sharedManager;
    }
}
