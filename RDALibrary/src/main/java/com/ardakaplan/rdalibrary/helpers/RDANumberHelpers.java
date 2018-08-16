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

    public static String limitDoubleValue(double doubleValue, int digitLimit) {

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());

        decimalFormat.setMaximumFractionDigits(digitLimit);

        decimalFormat.setMinimumFractionDigits(digitLimit);

        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        return decimalFormat.format(doubleValue);
    }

//    public static DecimalFormat createBridgeDecimalFormatWithNotGrouping(int decimal) {
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
//    public static DecimalFormat createBridgeDecimalFormatWithGrouping(int decimal) {
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