package com.ardakaplan.rdalibrary.helpers;

import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorInt;

/**
 * Created by Arda Kaplan at 1.12.2020 - 14:12
 * <p>
 * ardakaplan101@gmail.com
 */
public final class RDADrawableHelpers {

    private RDADrawableHelpers() {

    }

    public static GradientDrawable getGradientDrawable(@ColorInt int color, int radius) {

        GradientDrawable gradientDrawable = new GradientDrawable();

        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        gradientDrawable.setCornerRadii(new float[]{radius, radius, radius, radius, radius, radius, radius, radius});

        gradientDrawable.setColor(color);

        return gradientDrawable;
    }
}
