package com.ardakaplan.rdalibrary.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

/**
 * Created by Arda Kaplan at 01-Jun-20 - 19:18
 * <p>
 * ardakaplan101@gmail.com
 */

public class RDAThemeHelpers {


    public static @ColorInt
    Integer getColorFromThemeActivity(Activity activity, @AttrRes int themeColor) {

        return getColor(activity, themeColor);
    }

    public static @ColorInt
    Integer getColor(Context context, @AttrRes int themeColor) {

        TypedValue typedValue = new TypedValue();

        Resources.Theme theme = context.getTheme();

        theme.resolveAttribute(themeColor, typedValue, true);


        return ContextCompat.getColor(context, typedValue.resourceId);
    }

    public static @ColorRes
    int getColorId(Context context, @AttrRes int themeColor) {

        TypedValue typedValue = new TypedValue();

        Resources.Theme theme = context.getTheme();

        theme.resolveAttribute(themeColor, typedValue, true);

        return typedValue.resourceId;
    }

    public static Drawable getDrawable(Context context, @AttrRes int themeDrawable) {

        TypedValue typedValue = new TypedValue();

        Resources.Theme theme = context.getTheme();

        theme.resolveAttribute(themeDrawable, typedValue, true);


        return ContextCompat.getDrawable(context, typedValue.resourceId);
    }

    public static @DrawableRes
    int getDrawableIdFromTheme(Context context, @AttrRes int themeDrawable) {

        TypedValue typedValue = new TypedValue();

        Resources.Theme theme = context.getTheme();

        theme.resolveAttribute(themeDrawable, typedValue, true);

        return typedValue.resourceId;
    }
}
