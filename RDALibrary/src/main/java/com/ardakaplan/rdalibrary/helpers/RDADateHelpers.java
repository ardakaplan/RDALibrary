package com.ardakaplan.rdalibrary.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings({"WeakerAccess", "unused"})
public class RDADateHelpers {

    public static final long ONE_SECOND_MILLIS = 1000;

    public static final long ONE_MINUTES_MILLIS = 60 * ONE_SECOND_MILLIS;

    public static final long ONE_HOUR_MILLIS = 60 * ONE_MINUTES_MILLIS;

    public static final long ONE_DAY_MILLIS = 24 * ONE_HOUR_MILLIS;

    private RDADateHelpers() {

    }

    public static Calendar dateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        return calendar;
    }

    public static Date getDate(String date, String format, Locale locale) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat(format, locale);

        return dateFormat.parse(date);
    }

    public static String formatDate(String dateToFormat, String inputFormat, String outputFormat, Locale locale) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat(inputFormat, locale);

        return RDADateHelpers.formatDate(dateFormat.parse(dateToFormat), outputFormat, locale);
    }


    /**
     * @param milliSeconds date miliseconds to convert
     * @param formatString formatting type
     *                     - dd MMMM yyyy HH:mm:ss
     *                     - dd MMM yyyy
     *                     - HH:mm:ss
     *                     - MM/dd/yyyy
     *                     - dd MMMM
     *                     - dd.MM.yyyy
     */
    public static String formatDate(long milliSeconds, String formatString, Locale locale) {

        return formatDate(new Date(milliSeconds), formatString, checkLocale(locale));
    }

    /**
     * @param date         date miliseconds to convert
     * @param formatString formatting type
     */
    public static String formatDate(Date date, String formatString, Locale locale) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString, checkLocale(locale));

        return simpleDateFormat.format(date);
    }

    public static String formatDate(Calendar calendar, String format, Locale locale) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, checkLocale(locale));

        return simpleDateFormat.format(calendar.getTime());
    }


    private static Locale checkLocale(Locale locale) {

        if (locale == null) {

            locale = Locale.getDefault();
        }

        return locale;
    }
}
