package com.ardakaplan.rdalibrary.data.models.theme;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;

import java.util.List;

/**
 * Created by Arda Kaplan at 31-Jul-20 - 23:45
 * <p>
 * ardakaplan101@gmail.com
 */
public final class ApplicationTheme extends RDAObject {

    private Theme defaultTheme;
    private List<Theme> allDefinedThemes;

    public ApplicationTheme(Theme defaultTheme, List<Theme> allDefinedThemes) {
        this.defaultTheme = defaultTheme;
        this.allDefinedThemes = allDefinedThemes;
    }

    public Theme getDefaultTheme() {
        return defaultTheme;
    }

    public List<Theme> getAllDefinedThemes() {
        return allDefinedThemes;
    }
}