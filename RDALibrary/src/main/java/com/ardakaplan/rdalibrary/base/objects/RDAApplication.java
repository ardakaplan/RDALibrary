package com.ardakaplan.rdalibrary.base.objects;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;

import com.ardakaplan.rdalibrary.di.CustomDispatchingAndroidInjector;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalibrary.managers.LanguageManager;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class RDAApplication extends Application implements HasCustomActivityInjector, HasSupportFragmentInjector, HasBroadcastReceiverInjector, HasServiceInjector {

    @Inject
    LanguageManager languageManager;

    @Inject
    CustomDispatchingAndroidInjector<Activity> activityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;

    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector;

    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        RDALogger.start(getRDALoggerTag()).enableLogging(doesRDALoggerWork());

        initDagger();

        initRDADialog();

        RDALogger.logLifeCycle(this.getClass().getSimpleName());
    }

    protected abstract String getRDALoggerTag();

    protected abstract boolean doesRDALoggerWork();

    protected abstract void initDagger();

    protected abstract void initRDADialog();

    public LanguageManager.Language getSelectedLanguage() {
        return languageManager.getSelectedLanguage();
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

    @Override
    public CustomDispatchingAndroidInjector<Activity> activityInjector() {

        return activityInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {

        return mFragmentInjector;
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {

        return broadcastReceiverInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {

        return serviceDispatchingAndroidInjector;
    }
}
