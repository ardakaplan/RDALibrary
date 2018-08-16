package com.ardakaplan.rdalibrary.helpers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.ardakaplan.rdalibrary.R;
import com.ardakaplan.rdalibrary.logger.RDALogger;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"unused", "WeakerAccess"})
public final class RDADeviceHelpers {

    private RDADeviceHelpers() {

    }

    public static boolean isSimCardAvailable(Context context) {

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        return !(telephonyManager.getSimState() == TelephonyManager.SIM_STATE_ABSENT);
    }


    /**
     * returning network info
     *
     */
    @SuppressLint("MissingPermission")
    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    /**
     * returnining network type name
     *
     */
    public static String getNetworkType(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);

        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return "WIFI";
        } else {
            return networkInfo.getSubtypeName();
        }

    }

    public static String getNetworkOperatorName(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName();
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getPhoneNumber(Activity activity) {
        return ((TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
    }


    public static int getApplicationVersionCode(Activity activity) {

        try {

            return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;

        } catch (NameNotFoundException e) {

            e.printStackTrace();

            return 1;
        }
    }

    public static String getDeviceLanguage() {

        return Locale.getDefault().getLanguage().toUpperCase(Locale.ENGLISH);
    }

    public static boolean isNetworkAvailable(Activity activity) {

        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        @SuppressWarnings("ConstantConditions") @SuppressLint("MissingPermission")
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void closeKeyboard(Activity activity) {

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null) {

            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static void closeKeyboard(Activity activity, EditText editText) {

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null) {

            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    public static boolean isAppInstalled(Context context, String packageName) {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);

        return intent != null;
    }

    public static void writeDeviceInfo(Activity activity) {
        // cihazin hangi values klasorunu kullandigini bulmak icin log
        RDALogger.verbose("VALUES FOLDER : " + getDeviceResourcesFolder(activity));
        // cihazin ekran boyutlari
        RDALogger.verbose("Device screen height : " + getScreenHeight(activity));

        RDALogger.verbose("Device screen width : " + getScreenWidth(activity));
        // ekran cozunurlugu
        RDALogger.verbose("Device Screen Density Type : " + getDensityType(activity));
        // api level
        RDALogger.verbose("Device Api level : " + getDeviceApiLevel());
        // marka
        RDALogger.verbose("Device Brand :" + getDeviceBrand());
        // model
        RDALogger.verbose("Device Model :" + getDeviceModel());
        // uretici
        RDALogger.verbose("Device Manufacturer :" + getDeviceManufacturer());
        // tablet mi
        RDALogger.verbose("Is Device tablet : " + isTablet(activity));
    }

    public static String getDeviceResourcesFolder(Context context) {
        return context.getString(R.string.folder_name);
    }


    public static int getDeviceApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getAndroidVersionName() {
        String versionName = "";
        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (fieldValue == Build.VERSION.SDK_INT) {
                versionName = fieldName;
            }
        }
        return versionName;
    }

    public static String getDeviceVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPhoneName() {
        BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
        return myDevice.getName();
    }

    public static String getTotalRAM() {

        RandomAccessFile reader = null;
        String load = null;
        DecimalFormat twoDecimalForm = new DecimalFormat("#.##");
        double totRam = 0;
        String lastValue = "";
        try {
            reader = new RandomAccessFile("/proc/meminfo", "r");
            load = reader.readLine();

            // Get the Number value from the string
            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(load);
            String value = "";
            while (m.find()) {
                value = m.group(1);
                // System.out.println("Ram : " + value);
            }
            reader.close();

            totRam = Double.parseDouble(value);
            // totRam = totRam / 1024;

            double mb = totRam / 1024.0;
            double gb = totRam / 1048576.0;
            double tb = totRam / 1073741824.0;

            if (tb > 1) {
                lastValue = twoDecimalForm.format(tb).concat(" TB");
            } else if (gb > 1) {
                lastValue = twoDecimalForm.format(gb).concat(" GB");
            } else if (mb > 1) {
                lastValue = twoDecimalForm.format(mb).concat(" MB");
            } else {
                lastValue = twoDecimalForm.format(totRam).concat(" KB");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Streams.close(reader);
        }

        return lastValue;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static int getScreenWidth(Activity activity) {

        try {

            DisplayMetrics displaymetrics = new DisplayMetrics();

            activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

            return displaymetrics.widthPixels;

        } catch (NullPointerException e) {

            e.printStackTrace();

            return 0;
        }
    }

    public static int getScreenHeight(Activity activity) {

        try {

            DisplayMetrics displaymetrics = new DisplayMetrics();

            activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

            return displaymetrics.heightPixels;

        } catch (NullPointerException e) {

            e.printStackTrace();

            return 0;
        }
    }

    /**
     * Cihazin hangi cozunurluge ait oldugunun bilgisini verir
     *
     */
    public static String getDensityType(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int density = metrics.densityDpi;

        String screenType = "";

        switch (density) {
            case DisplayMetrics.DENSITY_HIGH:
                screenType = "high";
                break;
            case DisplayMetrics.DENSITY_LOW:
                screenType = "low";
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                screenType = "xxhigh";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                screenType = "medium";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                screenType = "xhigh";
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                screenType = "xxxhigh";
                break;

            default:
                screenType = "N/A";
                break;
        }
        return screenType;
    }

    public static String getDrawableFolder(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int density = metrics.densityDpi;

        String screenType = "";

        switch (density) {

            case DisplayMetrics.DENSITY_LOW:
                screenType = "ldpi";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                screenType = "mdpi";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                screenType = "hdpi";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                screenType = "xhdpi";
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                screenType = "xxhdpi";
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                screenType = "xxxhdpi";
                break;

            default:
                screenType = "N/A";
                break;
        }
        return screenType;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

}
