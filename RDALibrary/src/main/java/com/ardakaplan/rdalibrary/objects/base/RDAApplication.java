package com.ardakaplan.rdalibrary.objects.base;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;

import com.ardakaplan.rdalibrary.di.CustomDispatchingAndroidInjector;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;


public abstract class RDAApplication extends Application implements HasCustomActivityInjector {

    @Inject
    CustomDispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();

        RDALogger.logLifeCycle(this.getClass().getSimpleName());
    }

    protected abstract void initDagger();


    @Override
    public CustomDispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
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
