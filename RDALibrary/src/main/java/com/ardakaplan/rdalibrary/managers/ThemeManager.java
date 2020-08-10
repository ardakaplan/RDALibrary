package com.ardakaplan.rdalibrary.managers;

import com.ardakaplan.rdalibrary.base.RDASharedProperty;
import com.ardakaplan.rdalibrary.data.models.theme.ApplicationTheme;
import com.ardakaplan.rdalibrary.data.models.theme.Theme;
import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Arda Kaplan at 04-Jun-20 - 16:13
 * <p>
 * ardakaplan101@gmail.com
 */
@Singleton
public class ThemeManager {

    private ApplicationThemeSharedProperty applicationThemeSharedProperty;
    private ApplicationTheme applicationTheme;

    @Inject
    ThemeManager(ApplicationThemeSharedProperty applicationThemeSharedProperty, ApplicationTheme applicationTheme) {
        this.applicationThemeSharedProperty = applicationThemeSharedProperty;
        this.applicationTheme = applicationTheme;
    }

    public boolean changeTheme(Theme theme) {

        if (applicationThemeSharedProperty.getValue() != null) {

            if (theme.getId() != applicationThemeSharedProperty.getValue()) {

                applicationThemeSharedProperty.saveValue(theme.getId());

                return true;

            } else {

                return false;
            }

        } else {

            applicationThemeSharedProperty.saveValue(theme.getId());

            return true;
        }
    }

    public Theme getCurrentTheme() {

        if (applicationThemeSharedProperty.getValue() != null) {

            for (Theme theme : applicationTheme.getAllDefinedThemes()) {

                if (theme.getId() == applicationThemeSharedProperty.getValue()) {

                    return theme;
                }
            }
        }

        return applicationTheme.getDefaultTheme();
    }

    public List<Theme> getAllThemes() {

        return applicationTheme.getAllDefinedThemes();
    }

    public Theme getDefaultTheme() {

        return applicationTheme.getDefaultTheme();
    }

    public static class ApplicationThemeSharedProperty extends RDASharedProperty<Integer> {

        @Inject
        ApplicationThemeSharedProperty(RDASharedHelpers rdaSharedHelpers) {
            super(rdaSharedHelpers);
        }

        @Override
        public Integer getDefault() {
            return 0;
        }


        @Override
        public Integer getValue() {
            return getIntegerValue();
        }

        @Override
        protected String getKey() {
            return "SELECTED_APPLICATION_THEME";
        }
    }


}
