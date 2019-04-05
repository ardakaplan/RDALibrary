package com.ardakaplan.rdalibrarytest.di;

import com.ardakaplan.rdalibrarytest.ui.language.LanguageTestActivity;
import com.ardakaplan.rdalibrarytest.ui.splash.SplashModule;
import com.ardakaplan.rdalibrarytest.ui.filetest.FileTestActivity;
import com.ardakaplan.rdalibrarytest.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {SplashModule.class})
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract FileTestActivity bindFileTestActivity();

    @ContributesAndroidInjector
    abstract LanguageTestActivity bindLanguageTestActivity();
}
