package com.ardakaplan.rdalibrary.di;

import android.app.Activity;

import dagger.android.HasActivityInjector;

public interface HasCustomActivityInjector extends HasActivityInjector {

    @Override
    CustomDispatchingAndroidInjector<Activity> activityInjector();
}
