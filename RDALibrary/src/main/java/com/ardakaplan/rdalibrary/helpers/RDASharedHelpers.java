package com.ardakaplan.rdalibrary.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author Arda Kaplan arda.kaplan09@gmail.com
 */
@SuppressWarnings({"unused", "SameParameterValue"})
@Singleton
public final class RDASharedHelpers {

    private Context context;

    @Inject
    RDASharedHelpers(Context context) {

        this.context = context;
    }

    private SharedPreferences getSharedPreferences() {

        String applicationName = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();

        return context.getSharedPreferences(applicationName, MODE_PRIVATE);
    }

    public String getString(String key, String defaultValue) {

        return getSharedPreferences().getString(key, defaultValue);
    }

    public void putString(String key, String value) {

        SharedPreferences.Editor editor = getSharedPreferences().edit().putString(key, value);

        editor.apply();
    }

    public int getInt(String key, int defaultValue) {

        return getSharedPreferences().getInt(key, defaultValue);
    }

    public void putInt(String key, int value) {

        SharedPreferences.Editor editor = getSharedPreferences().edit().putInt(key, value);

        editor.apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {

        return getSharedPreferences().getBoolean(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {

        SharedPreferences.Editor editor = getSharedPreferences().edit().putBoolean(key, value);

        editor.apply();
    }

    public Long getLong(String key) {

        return getSharedPreferences().getLong(key, 0);
    }

    public void putLong(String key, Long value) {

        SharedPreferences.Editor editor = getSharedPreferences().edit().putLong(key, value);

        editor.apply();
    }

    public void delete(String key) {

        getSharedPreferences().edit().remove(key).apply();
    }

    public void deleteAll() {

        getSharedPreferences().edit().clear().apply();
    }
}