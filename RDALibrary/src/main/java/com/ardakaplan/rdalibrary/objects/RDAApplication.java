package com.ardakaplan.rdalibrary.objects;

import android.app.Application;
import android.content.res.Configuration;

import com.ardakaplan.rdalogger.RDALogger;


public abstract class RDAApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RDALogger.logLifeCycle(this.getClass().getSimpleName());
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        RDALogger.logLifeCycle(this.getClass().getSimpleName());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        RDALogger.logLifeCycle(this.getClass().getSimpleName());

        System.gc();

        RDALogger.info("GC will work.");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        RDALogger.logLifeCycle(this.getClass().getSimpleName());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        RDALogger.logLifeCycle(this.getClass().getSimpleName());
    }
}
