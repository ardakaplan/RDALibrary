package com.ardakaplan.rdalibrarytest.di;

import com.ardakaplan.rdalibrary.data.models.theme.RDAApplicationThemeAdjuster;
import com.ardakaplan.rdalibrary.data.models.theme.RDATheme;
import com.ardakaplan.rdalibrarytest.R;

import java.util.Arrays;

import dagger.Module;
import dagger.Provides;

@Module
public class ThemeModule {

    //0 yok anlamında kullanıldığı için 1 den başla
    public static final RDATheme TEST_1 = new RDATheme(1, R.string.theme_test_1, R.style.AppTheme_test_1);
    public static final RDATheme TEST_2 = new RDATheme(2, R.string.theme_test_2, R.style.AppTheme_test_2);

    @Provides
    RDAApplicationThemeAdjuster providesApplicationTheme() {

        return new RDAApplicationThemeAdjuster(TEST_1, Arrays.asList(TEST_1, TEST_2));
    }
}
