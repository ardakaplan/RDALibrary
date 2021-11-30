package com.ardakaplan.rdalibrary.helpers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.ardakaplan.rdalibrary.R;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

@SuppressWarnings({"unused", "WeakerAccess"})
public final class RDADeviceHelpers {

    private Context context;

    @Inject
    RDADeviceHelpers(Context context) {

        this.context = context;
    }

    public String getDeviceName() {

        if (Build.VERSION.SDK_INT >= 25) {

            return Settings.Global.getString(context.getContentResolver(), Settings.Global.DEVICE_NAME);

        } else {

            return Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
        }
    }

    public boolean isSimCardAvailable() {

        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        return !(telephonyManager.getSimState() == TelephonyManager.SIM_STATE_ABSENT);
    }

    /**
     * returning network info
     */
    @SuppressLint("MissingPermission")
    public NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    /**
     * returning network type name
     */
    public String getNetworkType() throws NullPointerException {

        NetworkInfo networkInfo = getNetworkInfo();

        if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return "WIFI";
        } else {
            return networkInfo.getSubtypeName();
        }

    }

    public String getNetworkOperatorName() {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName();
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public String getPhoneNumber() {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
    }

    public String getDeviceLanguage() {

        return Locale.getDefault().getLanguage().toUpperCase(Locale.ENGLISH);
    }

    public boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        @SuppressWarnings("ConstantConditions") @SuppressLint("MissingPermission")
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void closeKeyboard(Activity activity) {

        if (activity != null) {

            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

            if (inputMethodManager != null) {

                inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    public static void closeKeyboard(Activity activity, EditText editText) {

        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputMethodManager != null) {

            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    public boolean isAppInstalled(String packageName) {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);

        return intent != null;
    }

    public void writeDeviceInfo() {
        // cihazin hangi values klasorunu kullandigini bulmak icin log
        RDALogger.verbose("VALUES FOLDER : " + getDeviceResourcesFolder());
        // cihazin ekran boyutlari
        RDALogger.verbose("Device screen height : " + getScreenHeight());

        RDALogger.verbose("Device screen width : " + getScreenWidth());
        // ekran cozunurlugu
        RDALogger.verbose("Device Screen Density Type : " + getDensityType());
        // api level
        RDALogger.verbose("Device Api level : " + getDeviceApiLevel());
        // marka
        RDALogger.verbose("Device Brand :" + getDeviceBrand());
        // model
        RDALogger.verbose("Device Model :" + getDeviceModel());
        // uretici
        RDALogger.verbose("Device Manufacturer :" + getDeviceManufacturer());
        // tablet mi
        RDALogger.verbose("Is Device tablet : " + isTablet());
    }

    public String getDeviceResourcesFolder() {
        return context.getString(R.string.folder_name);
    }


    public int getDeviceApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public String getAndroidVersionName() {
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

    public String getDeviceVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getTotalRAM() {

        RandomAccessFile reader;
        String load;
        DecimalFormat twoDecimalForm = new DecimalFormat("#.##");
        double totRam;
        String lastValue = "";
        try {
            reader = new RandomAccessFile("/proc/meminfo", "r");
            load = reader.readLine();// Get the Number value from the string
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
        }

        return lastValue;
    }

    public boolean isTablet() {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static int getScreenWidth() {

        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {

        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public int getScreenDensity() {

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        return (int) (metrics.density * 160f);
    }

    /**
     * Cihazin hangi cozunurluge ait oldugunun bilgisini verir
     */
    public String getDensityType() {

        DisplayMetrics metrics = new DisplayMetrics();

        int density = metrics.densityDpi;

        RDALogger.info("DP " + density);

        String screenType;

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

    public static String getDrawableFolder() {

        int density = new DisplayMetrics().densityDpi;

        String screenType;

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
