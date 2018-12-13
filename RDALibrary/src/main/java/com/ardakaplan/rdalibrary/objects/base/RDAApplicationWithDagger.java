package com.ardakaplan.rdalibrary.objects.base;

import android.app.Activity;

import com.ardakaplan.rdalibrary.di.CustomDispatchingAndroidInjector;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;

import javax.inject.Inject;

public abstract class RDAApplicationWithDagger extends RDAApplication implements HasCustomActivityInjector {

    @Inject
    CustomDispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        initDagger();
    }

    protected abstract void initDagger();


    @Override
    public CustomDispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
