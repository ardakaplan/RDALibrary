package com.ardakaplan.rdalibrarytest;


import com.ardakaplan.rdalibrary.base.objects.RDAApplication;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalibrarytest.di.AppComponent;
import com.ardakaplan.rdalibrarytest.di.DaggerAppComponent;
import com.ardakaplan.rdalogger.RDALogger;

/**
 * Created by Arda Kaplan on 10.08.2018 - 17:44
 */
public class TestApplication extends RDAApplication implements HasCustomActivityInjector {

    @Override
    public void onCreate() {
        super.onCreate();

        RDALogger.info(rdaApplicationOpeningType);
    }

    @Override
    protected int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    @Override
    protected String getRDALoggerTag() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean doesRDALoggerWork() {
        return true;
    }

    @Override
    protected void initDagger() {

        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();

        appComponent.inject(this);
    }
}
