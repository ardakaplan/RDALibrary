package com.ardakaplan.rdalibrary.helpers;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings({"WeakerAccess", "unused"})
@SuppressLint("SimpleDateFormat")
public class RDADateHelpers {

    public static final long ONE_DAY_MILLIS = 86400000L;

    private RDADateHelpers() {

    }

    public static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        return calendar;
    }

    /**
     * @param miliSeconds  date miliseconds to convert
     * @param formatString formatting type
     *                     - dd MMMM yyyy HH:mm:ss
     *                     - dd MMM yyyy
     *                     - HH:mm:ss
     *                     - MM/dd/yyyy
     *                     - dd MMMM
     *                     - dd.MM.yyyy
     */
    public static String formatDate(long miliSeconds, String formatString) {

        return formatDate(new Date(miliSeconds), formatString);
    }

    /**
     * @param date         date miliseconds to convert
     * @param formatString formatting type
     */
    public static String formatDate(Date date, String formatString) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

        return simpleDateFormat.format(date);
    }

    public static String formatDate(Calendar calendar, String format) {

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(calendar.getTime());
    }
}
