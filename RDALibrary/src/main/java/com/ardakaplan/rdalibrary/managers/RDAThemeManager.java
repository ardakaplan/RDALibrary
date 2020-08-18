package com.ardakaplan.rdalibrary.managers;

import com.ardakaplan.rdalibrary.base.RDASharedProperty;
import com.ardakaplan.rdalibrary.data.models.theme.RDAApplicationThemeAdjuster;
import com.ardakaplan.rdalibrary.data.models.theme.RDATheme;
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
public class RDAThemeManager {

    private ApplicationThemeSharedProperty applicationThemeSharedProperty;
    private RDAApplicationThemeAdjuster RDAApplicationThemeAdjuster;

    @Inject
    RDAThemeManager(ApplicationThemeSharedProperty applicationThemeSharedProperty, RDAApplicationThemeAdjuster RDAApplicationThemeAdjuster) {
        this.applicationThemeSharedProperty = applicationThemeSharedProperty;
        this.RDAApplicationThemeAdjuster = RDAApplicationThemeAdjuster;
    }

    public boolean changeTheme(RDATheme RDATheme) {

        if (applicationThemeSharedProperty.getValue() != null) {

            if (RDATheme.getId() != applicationThemeSharedProperty.getValue()) {

                applicationThemeSharedProperty.saveValue(RDATheme.getId());

                return true;

            } else {

                return false;
            }

        } else {

            applicationThemeSharedProperty.saveValue(RDATheme.getId());

            return true;
        }
    }

    public RDATheme getCurrentTheme() {

        if (applicationThemeSharedProperty.getValue() != null) {

            for (RDATheme RDATheme : RDAApplicationThemeAdjuster.getAllDefinedRDAThemes()) {

                if (RDATheme.getId() == applicationThemeSharedProperty.getValue()) {

                    return RDATheme;
                }
            }
        }

        return RDAApplicationThemeAdjuster.getDefaultRDATheme();
    }

    public List<RDATheme> getAllThemes() {

        return RDAApplicationThemeAdjuster.getAllDefinedRDAThemes();
    }

    public RDATheme getDefaultTheme() {

        return RDAApplicationThemeAdjuster.getDefaultRDATheme();
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
