package com.ardakaplan.rdalibrary.helpers;

import android.annotation.SuppressLint;
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

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ardakaplan on 12/10/15.
 */
@SuppressWarnings("unused")
@Singleton
public class RDAApplicationHelpers {

    private Context context;

    @Inject
    public RDAApplicationHelpers(Context context) {
        this.context = context;
    }

    public int getAppVersionCode() {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAppVersionName() {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeHashKey() {

        try {
            @SuppressLint("PackageManagerGetSignatures")
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);

            for (Signature signature : packageInfo.signatures) {

                MessageDigest messageDigest = MessageDigest.getInstance("SHA");

                messageDigest.update(signature.toByteArray());

                RDALogger.info("Key Hash : " + Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void changeLanguage(String localeShortName) {

        Locale locale = new Locale(localeShortName);

        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = new Configuration(resources.getConfiguration());

        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    @SuppressWarnings("WeakerAccess")
    public String getPackageName() {
        return context.getPackageName();
    }
}
