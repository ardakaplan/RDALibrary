package com.ardakaplan.rdalibrary.di;

import com.ardakaplan.rdalibrary.data.models.theme.RDAApplicationThemeAdjuster;

import dagger.Module;
import dagger.Provides;

@Module
public class RDANoThemeModule {

    @Provides
    RDAApplicationThemeAdjuster providesApplicationTheme() {

        return new RDAApplicationThemeAdjuster(null, null);
    }
}
