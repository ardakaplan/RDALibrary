package com.ardakaplan.rdalibrarytest.di;

import com.ardakaplan.rdalibrarytest.di.modules.SplashModule;
import com.ardakaplan.rdalibrarytest.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {SplashModule.class})
    abstract SplashActivity bindSplashActivity();

}
