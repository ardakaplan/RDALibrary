package com.ardakaplan.rdalibrary.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author Arda Kaplan arda.kaplan09@gmail.com
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public final class RDASharedHelpers {


    private RDASharedHelpers() {

    }

    private static SharedPreferences getSharedPreferences(Context context) {

        String applicationName = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();

        return context.getSharedPreferences(applicationName, MODE_PRIVATE);
    }

    public static String getString(Context context, String key) {

        return getSharedPreferences(context).getString(key, "");
    }

    public static void putString(Context context, String key, String value) {

        SharedPreferences.Editor editor = getSharedPreferences(context).edit().putString(key, value);

        editor.apply();
    }

    public static int getInt(Context context, String key) {

        return getSharedPreferences(context).getInt(key, 0);
    }

    public static void putInt(Context context, String key, int value) {

        SharedPreferences.Editor editor = getSharedPreferences(context).edit().putInt(key, value);

        editor.apply();
    }

    public static boolean getBoolean(Context context, String key) {

        return getSharedPreferences(context).getBoolean(key, false);
    }

    public static void putBoolean(Context context, String key, boolean value) {

        SharedPreferences.Editor editor = getSharedPreferences(context).edit().putBoolean(key, value);

        editor.apply();
    }

    public static Long getLong(Context context, String key) {

        return getSharedPreferences(context).getLong(key, 0);
    }

    public static void putLong(Context context, String key, Long value) {

        SharedPreferences.Editor editor = getSharedPreferences(context).edit().putLong(key, value);

        editor.apply();
    }

    public static void delete(Context context, String key) {

        getSharedPreferences(context).edit().remove(key).apply();
    }

    public static void deleteAll(Context context) {

        getSharedPreferences(context).edit().clear().apply();
    }
}