package com.ardakaplan.rdalibrarytest.di;

import com.ardakaplan.rdalibrarytest.ui.filetest.FileTestActivity;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.FragmentA;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.FragmentB;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.FragmentC;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.FragmentTestActivity;
import com.ardakaplan.rdalibrarytest.ui.language.LanguageTestActivity;
import com.ardakaplan.rdalibrarytest.ui.splash.SplashActivity;
import com.ardakaplan.rdalibrarytest.ui.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {SplashModule.class})
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector
    abstract FileTestActivity bindFileTestActivity();

    @ContributesAndroidInjector
    abstract FragmentTestActivity FragmentTestActivity();

    @ContributesAndroidInjector
    abstract FragmentA FragmentA();

    @ContributesAndroidInjector
    abstract FragmentB FragmentB();

    @ContributesAndroidInjector
    abstract FragmentC FragmentC();

    @ContributesAndroidInjector
    abstract LanguageTestActivity bindLanguageTestActivity();
}
