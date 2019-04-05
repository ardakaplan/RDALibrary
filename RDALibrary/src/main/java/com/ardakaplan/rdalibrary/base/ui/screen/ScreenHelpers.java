package com.ardakaplan.rdalibrary.base.ui.screen;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

import java.util.Locale;

/**
 * Created by Arda Kaplan at 4/5/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
final class ScreenHelpers {

    private ScreenHelpers() {

    }

    protected static Context changeLanguage(Context context, Locale newLocale) {

        Configuration configuration = context.getResources().getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            configuration.setLocale(newLocale);

            LocaleList localeList = new LocaleList(newLocale);

            LocaleList.setDefault(localeList);

            configuration.setLocales(localeList);

            context = context.createConfigurationContext(configuration);

        } else {

            configuration.setLocale(newLocale);

            context = context.createConfigurationContext(configuration);
        }

        return context;
    }
}
