package com.ardakaplan.rdalibrary.base.objects;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.res.Configuration;

import androidx.fragment.app.Fragment;

import com.ardakaplan.rdalibrary.data.models.RDAApplicationOpeningChecker;
import com.ardakaplan.rdalibrary.data.models.language.RDAApplicationLanguageAdjuster;
import com.ardakaplan.rdalibrary.data.models.theme.RDAApplicationThemeAdjuster;
import com.ardakaplan.rdalibrary.data.shared.RDAOpeningCounterSharedProperty;
import com.ardakaplan.rdalibrary.di.CustomDispatchingAndroidInjector;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalibrary.managers.RDALanguageManager;
import com.ardakaplan.rdalibrary.managers.RDAThemeManager;
import com.ardakaplan.rdalogger.RDALogger;
import com.ardakaplan.rdalogger.RDALoggerConfig;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class RDAApplication extends Application implements HasCustomActivityInjector, HasSupportFragmentInjector, HasBroadcastReceiverInjector, HasServiceInjector {


    @Inject
    public RDALanguageManager rdaLanguageManager;
    @Inject
    public RDAThemeManager rdaThemeManager;
//    @Inject
//    RDAApplicationThemeAdjuster rdaApplicationThemeAdjuster;
//    @Inject
//    RDAApplicationLanguageAdjuster rdaApplicationLanguageAdjuster;
    @Inject
    RDAApplicationOpeningChecker rdaApplicationOpeningChecker;
    @Inject
    RDAOpeningCounterSharedProperty rdaOpeningCounterSharedProperty;

    @Inject
    CustomDispatchingAndroidInjector<Activity> activityInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentInjector;
    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    public RDAApplicationOpeningChecker.RDAApplicationOpeningType rdaApplicationOpeningType;

    @Override
    public void onCreate() {
        super.onCreate();

        RDALoggerConfig.setup(getRDALoggerTag()).enableLogging(doesRDALoggerWork());

        initDagger();

        getOpeningType();

        RDALogger.logLifeCycle(this.getClass().getSimpleName());

        changeOpeningCount();
    }

    private void getOpeningType() {

        rdaApplicationOpeningType = rdaApplicationOpeningChecker.getOpeningType(getVersionCode());
    }

    protected abstract int getVersionCode();

    private void changeOpeningCount() {

        rdaOpeningCounterSharedProperty.saveValue(rdaOpeningCounterSharedProperty.getValue() + 1);
    }

    protected abstract String getRDALoggerTag();

    protected abstract boolean doesRDALoggerWork();

    protected abstract void initDagger();

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
