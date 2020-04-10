package com.ardakaplan.rdalibrary.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;


/**
 * Created by Arda Kaplan at 1/13/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class RDASystemDialogHelpers {

    public static void showInfoDialog(Activity activity,
                                      String title,
                                      String message,
                                      boolean cancelable,
                                      String buttonText) {

        showOneButtonDialog(activity, title, message, cancelable, buttonText, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });
    }

    public static void showOneButtonDialog(Activity activity,
                                           String title,
                                           String message,
                                           boolean cancelable,
                                           String buttonText,
                                           DialogInterface.OnClickListener buttonClickListener) {

        showDialog(activity, title, message, cancelable, buttonText, buttonClickListener, null, null, null, null);
    }

    public static void showTwoButtonDialog(Activity activity,
                                           String title,
                                           String message,
                                           boolean cancelable,
                                           String positiveButtonText,
                                           DialogInterface.OnClickListener positiveButtonClickListener,
                                           String negativeButtonText,
                                           DialogInterface.OnClickListener negativeButtonClickListener) {

        showDialog(activity, title, message, cancelable, positiveButtonText, positiveButtonClickListener, negativeButtonText, negativeButtonClickListener, null, null);
    }

    public static void showThreeButtonDialog(Activity activity,
                                             String title,
                                             String message,
                                             boolean cancelable,
                                             String positiveButtonText,
                                             DialogInterface.OnClickListener positiveButtonClickListener,
                                             String negativeButtonText,
                                             DialogInterface.OnClickListener negativeButtonClickListener,
                                             String neutralButtonText,
                                             DialogInterface.OnClickListener neutralButtonClickListener) {

        showDialog(activity, title, message, cancelable, positiveButtonText, positiveButtonClickListener, negativeButtonText, negativeButtonClickListener, neutralButtonText, neutralButtonClickListener);
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
                                  @Nullable DialogInterface.OnClickListener neutralButtonClickListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setCancelable(cancelable);

        builder.setTitle(title).setMessage(message).setPositiveButton(positiveButtonText, positiveButtonClickListener);

        if (negativeButtonText != null && negativeButtonClickListener != null) {

            builder.setNegativeButton(negativeButtonText, negativeButtonClickListener);
        }

        if (neutralButtonText != null && neutralButtonClickListener != null) {

            builder.setNeutralButton(neutralButtonText, neutralButtonClickListener);
        }

        builder.show();
    }

    public static ProgressDialog getProgressDialog(Activity activity, @StringRes int messageID) {

        return getProgressDialog(activity, activity.getString(messageID));
    }

    public static ProgressDialog getProgressDialog(Activity activity, String message) {

        ProgressDialog progressDialog = new ProgressDialog(activity);

        progressDialog.setMessage(message);

        return progressDialog;
    }

}
