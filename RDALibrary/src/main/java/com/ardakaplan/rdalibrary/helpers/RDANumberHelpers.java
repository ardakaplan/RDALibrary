package com.ardakaplan.rdalibrary.helpers;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by ardakaplan on 21/02/16.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings("unused")
public final class RDANumberHelpers {

    private RDANumberHelpers() {

    }

    public static String limitDoubleValue(double doubleValue, int maximumFractionDigits, int minimumFractionDigits) {

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());

        decimalFormat.setMaximumFractionDigits(maximumFractionDigits);

        decimalFormat.setMinimumFractionDigits(minimumFractionDigits);

        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        return decimalFormat.format(doubleValue);
    }

    public static double limitDoubleValueToDouble(double doubleValue) {
        return (long) (doubleValue * 1e2) / 1e2;
    }

//    public static DecimalFormat createDecimalFormatWithNotGrouping(int decimal) {
//
//        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
//
//        decimalFormatSymbols.setDecimalSeparator('.');
//
//        StringBuilder format = new StringBuilder("########0");
//
//        if (decimal > 0) {
//
//            format.append(".");
//        }
//
//        for (int i = 0; i < decimal; i++) {
//
//            format.append("0");
//        }
//
//        return new DecimalFormat(format.toString(), decimalFormatSymbols);
//    }
//
//    public static DecimalFormat createDecimalFormatWithGrouping(int decimal) {
//
//        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
//
//        decimalFormatSymbols.setDecimalSeparator('.');
//
//        decimalFormatSymbols.setGroupingSeparator(',');
//
//        StringBuilder format = new StringBuilder("###,###,##0");
//
//        if (decimal > 0) {
//
//            format.append(".");
//        }
//
//        for (int i = 0; i < decimal; i++) {
//
//            format.append("0");
//        }
//
//        return new DecimalFormat(format.toString(), decimalFormatSymbols);
//    }
}