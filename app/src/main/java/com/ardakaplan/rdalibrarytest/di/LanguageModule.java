package com.ardakaplan.rdalibrarytest.di;

import com.ardakaplan.rdalibrary.data.models.language.ApplicationLanguage;
import com.ardakaplan.rdalibrary.data.models.language.Language;

import java.util.Arrays;

import dagger.Module;
import dagger.Provides;

@Module
public class LanguageModule {

    public static final Language TURKISH = new Language("tr", "TÜRKÇE");
    public static final Language ENGLISH = new Language("en", "ENGLISH");

    @Provides
    ApplicationLanguage providesApplicationLanguage() {

        return new ApplicationLanguage(ENGLISH, Arrays.asList(TURKISH, ENGLISH));
    }
}
