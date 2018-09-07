package com.ardakaplan.rdalibrary.helpers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Base64;

import com.ardakaplan.rdalogger.RDALogger;

import java.security.MessageDigest;
import java.util.Locale;

/**
 * Created by ardakaplan on 12/10/15.
 */
@SuppressWarnings("unused")
public class RDAApplicationHelpers {

    private RDAApplicationHelpers() {

    }

    public static int getAppVersionCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeHashKey(Activity activity) {

        try {
            @SuppressLint("PackageManagerGetSignatures")
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(RDAApplicationHelpers.getPackageName(activity), PackageManager.GET_SIGNATURES);

            for (Signature signature : packageInfo.signatures) {

                MessageDigest messageDigest = MessageDigest.getInstance("SHA");

                messageDigest.update(signature.toByteArray());

                RDALogger.info("Key Hash : " + Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void changeLanguage(Activity activity, String localeShortName) {

        Locale locale = new Locale(localeShortName);

        Locale.setDefault(locale);

        Resources resources = activity.getResources();

        Configuration configuration = new Configuration(resources.getConfiguration());

        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    @SuppressWarnings("WeakerAccess")
    public static String getPackageName(Context context) {
        return context.getPackageName();
    }
}
