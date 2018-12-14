package com.ardakaplan.rdalibrarytest;

import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalibrary.base.objects.RDAApplication;
import com.ardakaplan.rdalibrarytest.di.AppComponent;
import com.ardakaplan.rdalibrarytest.di.DaggerAppComponent;
import com.ardakaplan.rdalogger.RDALogger;

/**
 * Created by Arda Kaplan on 10.08.2018 - 17:44
 */
public class TestApplication extends RDAApplication implements HasCustomActivityInjector {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        RDALogger.start(getString(R.string.app_name)).enableLogging(true);
    }

    @Override
    protected void initDagger() {

        appComponent = DaggerAppComponent.builder().application(this).build();

        appComponent.inject(this);
    }
}
