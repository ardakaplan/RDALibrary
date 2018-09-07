package com.ardakaplan.rdalibrarytest;

import com.ardakaplan.rdalogger.RDALogger;
import com.ardakaplan.rdalibrary.objects.RDAApplication;

/**
 * Created by Arda Kaplan on 10.08.2018 - 17:44
 */
public class Application extends RDAApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        RDALogger.start(getString(R.string.app_name)).enableLogging(true);
    }
}
