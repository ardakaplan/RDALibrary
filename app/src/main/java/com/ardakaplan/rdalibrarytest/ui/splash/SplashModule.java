package com.ardakaplan.rdalibrarytest.ui.splash;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SplashModule {

    @Binds
    public abstract SplashContract.SplashPresenterContract providePresenter(SplashPresenter splashPresenter);
}
