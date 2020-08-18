package com.ardakaplan.rdalibrary.data.models.theme;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;

import java.util.List;

/**
 * Created by Arda Kaplan at 31-Jul-20 - 23:45
 * <p>
 * ardakaplan101@gmail.com
 */
public final class RDAApplicationThemeAdjuster extends RDAObject {

    private RDATheme defaultRDATheme;
    private List<RDATheme> allDefinedRDAThemes;

    public RDAApplicationThemeAdjuster(RDATheme defaultRDATheme, List<RDATheme> allDefinedRDAThemes) {
        this.defaultRDATheme = defaultRDATheme;
        this.allDefinedRDAThemes = allDefinedRDAThemes;
    }

    public RDATheme getDefaultRDATheme() {
        return defaultRDATheme;
    }

    public List<RDATheme> getAllDefinedRDAThemes() {
        return allDefinedRDAThemes;
    }
}