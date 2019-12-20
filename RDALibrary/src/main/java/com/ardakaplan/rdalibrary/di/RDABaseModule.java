package com.ardakaplan.rdalibrary.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;

@Module
public class RDABaseModule {

    @Provides
    @Singleton
    Map<String, AndroidInjector<Activity>> provideActivityInjectorMap() {
        return new HashMap<>();
    }

    @Provides
    @Singleton
    Map<String, AndroidInjector<Fragment>> provideFragmentInjectorMap() {
        return new HashMap<>();
    }


    @Provides
    @Singleton
    Context providesContext(Application application) {
        return application.getApplicationContext();
    }

}
