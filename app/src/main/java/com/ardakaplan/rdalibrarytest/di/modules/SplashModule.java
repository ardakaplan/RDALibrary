package com.ardakaplan.rdalibrarytest.di.modules;

import com.ardakaplan.rdalibrarytest.ui.splash.SplashContract;
import com.ardakaplan.rdalibrarytest.ui.splash.SplashPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SplashModule {

    @Binds
    public abstract SplashContract.SplashPresenterContract providePresenter(SplashPresenter splashPresenter);
}
