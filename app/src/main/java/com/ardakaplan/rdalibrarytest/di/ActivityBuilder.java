package com.ardakaplan.rdalibrarytest.di;

import com.ardakaplan.rdalibrarytest.ui.ThemeTestActivity;
import com.ardakaplan.rdalibrarytest.ui.filetest.FileTestActivity;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.InnerFragmentA;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.InnerFragmentB;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.InnerFragmentC;
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
    abstract ThemeTestActivity bindThemeTestActivity();

    @ContributesAndroidInjector
    abstract FileTestActivity bindFileTestActivity();

    @ContributesAndroidInjector
    abstract FragmentTestActivity FragmentTestActivity();

    @ContributesAndroidInjector
    abstract InnerFragmentA FragmentA();

    @ContributesAndroidInjector
    abstract InnerFragmentB FragmentB();

    @ContributesAndroidInjector
    abstract InnerFragmentC FragmentC();

    @ContributesAndroidInjector
    abstract LanguageTestActivity bindLanguageTestActivity();
}
