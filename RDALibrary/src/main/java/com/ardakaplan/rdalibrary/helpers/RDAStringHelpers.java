package com.ardakaplan.rdalibrary.helpers;


import android.app.Activity;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.ardakaplan.rdalogger.RDALogger;
import com.google.gson.Gson;

import java.net.URLDecoder;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


@SuppressWarnings("unused")
public final class RDAStringHelpers {

    private RDAStringHelpers() {
    }

    public static String getAsJson(Object object) {

        return new Gson().toJson(object);
    }

    /**
     * Verilen metni decode eder
     * <p/>
     * -Turkce karakter kullanimi icin
     */
    @SuppressWarnings("deprecation")
    public static String decodeString(String text) {
        return URLDecoder.decode(text);
    }

    public static SpannableString putDrawableIntoText(Activity activity, int stringID, String placeHolder, int drawableID) {

        String text = activity.getString(stringID);

        SpannableString spannableString = new SpannableString(text);

        int placeHolderIndex = text.indexOf(placeHolder);

        spannableString.setSpan(new ImageSpan(activity, drawableID), placeHolderIndex, placeHolderIndex + placeHolder.length(), 0);

        return spannableString;
    }

    public static SpannableString putDrawableIntoText(Activity activity, String text, String placeHolder, int drawableID) {

        SpannableString spannableString = new SpannableString(text);

        int placeHolderIndex = text.indexOf(placeHolder);

        spannableString.setSpan(new ImageSpan(activity, drawableID), placeHolderIndex, placeHolderIndex + placeHolder.length(), 0);

        return spannableString;
    }

    public static SpannableString putDrawableIntoText(Activity activity, SpannableString spannableString, String text, String placeHolder, int drawableID) {

        int placeHolderIndex = text.indexOf(placeHolder);

        spannableString.setSpan(new ImageSpan(activity, drawableID), placeHolderIndex, placeHolderIndex + placeHolder.length(), 0);

        return spannableString;
    }


    public static boolean isEmpty(String text) {

        return text == null || text.trim().equals("");
    }

    public static boolean isValidEMailAddress(String eMail) {
        boolean isValid = false;

        InternetAddress internetAddress;
        try {
            internetAddress = new InternetAddress(eMail);
            internetAddress.validate();
            isValid = true;
        } catch (AddressException e) {
            RDALogger.warn("Invalid e-mail");
        }
        return isValid;
    }


}
