package com.ardakaplan.rdalibrary.base.objects;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;

import com.ardakaplan.rdalibrary.di.CustomDispatchingAndroidInjector;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public abstract class RDAApplication extends Application implements HasCustomActivityInjector, HasSupportFragmentInjector {

    @Inject
    CustomDispatchingAndroidInjector<Activity> activityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

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
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentInjector;
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
