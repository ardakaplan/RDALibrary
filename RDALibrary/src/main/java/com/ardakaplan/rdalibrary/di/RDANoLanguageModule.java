package com.ardakaplan.rdalibrary.di;

import com.ardakaplan.rdalibrary.data.models.language.RDAApplicationLanguageAdjuster;
import com.ardakaplan.rdalibrary.data.models.language.RDALanguage;

import java.util.Arrays;
import java.util.Locale;

import dagger.Module;
import dagger.Provides;

@Module
public class RDANoLanguageModule {


    @Provides
    RDAApplicationLanguageAdjuster providesApplicationLanguage() {

        return new RDAApplicationLanguageAdjuster(null, null);
    }
}
