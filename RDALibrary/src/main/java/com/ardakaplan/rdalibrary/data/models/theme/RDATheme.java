package com.ardakaplan.rdalibrary.data.models.theme;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.ardakaplan.rdalibrary.base.objects.RDAObject;

/**
 * Created by Arda Kaplan at 10-Aug-20 - 11:06
 * <p>
 * ardakaplan101@gmail.com
 */
public class RDATheme extends RDAObject {

    private int Id;
    private @StringRes
    int themeName;
    private @StyleRes
    int style;

    public RDATheme(int id, int themeName, int style) {
        Id = id;
        this.themeName = themeName;
        this.style = style;
    }

    public int getThemeName() {
        return themeName;
    }

    public int getStyle() {
        return style;
    }

    public int getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RDATheme RDATheme = (RDATheme) o;
        return Id == RDATheme.Id;
    }
}
