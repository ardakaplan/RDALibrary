package com.ardakaplan.rdalibrary.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;

/**
 * Created by Arda Kaplan at 1/13/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public final class RDADialogHelpers {

    private RDADialogHelpers() {

    }

    public static void showOneButtonDialog(Activity activity,
                                           String title,
                                           String message,
                                           boolean cancelable,
                                           String buttonText,
                                           DialogInterface.OnClickListener buttonClickListener) {

        showDialog(activity, title, message, cancelable, buttonText, buttonClickListener, null, null, null, null);
    }

    public static void showDialog(Activity activity,
                                  String title,
                                  String message,
                                  boolean cancelable,
                                  String positiveButtonText,
                                  DialogInterface.OnClickListener positiveButtonClickListener,
                                  @Nullable String negativeButtonText,
                                  @Nullable DialogInterface.OnClickListener negativeButtonClickListener,
                                  @Nullable String neutralButtonText,
                                  @Nullable DialogInterface.OnClickListener neutralButtonClickListener
    ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setCancelable(cancelable);

        builder.setTitle(title).setMessage(message).setPositiveButton(positiveButtonText, positiveButtonClickListener);

        if (negativeButtonText != null) {

            builder.setNegativeButton(negativeButtonText, negativeButtonClickListener);
        }

        if (neutralButtonText != null) {

            builder.setNeutralButton(neutralButtonText, neutralButtonClickListener);
        }

        builder.show();
    }
}
