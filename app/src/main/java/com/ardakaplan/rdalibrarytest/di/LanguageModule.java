package com.ardakaplan.rdalibrarytest.di;

import com.ardakaplan.rdalibrary.data.models.language.RDAApplicationLanguageAdjuster;
import com.ardakaplan.rdalibrary.data.models.language.RDALanguage;

import java.util.Arrays;

import dagger.Module;
import dagger.Provides;

@Module
public class LanguageModule {

    public static final RDALanguage TURKISH = new RDALanguage("tr", "TÜRKÇE");
    public static final RDALanguage ENGLISH = new RDALanguage("en", "ENGLISH");

    @Provides
    RDAApplicationLanguageAdjuster providesApplicationLanguage() {

        return new RDAApplicationLanguageAdjuster(ENGLISH, Arrays.asList(TURKISH, ENGLISH));
    }
}
