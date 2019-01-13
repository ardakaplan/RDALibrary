package com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog;

import android.app.Activity;
import android.support.annotation.StyleRes;

/**
 * Created by Arda Kaplan at 1/13/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public final class RDADialogHelpers {

    private RDADialogHelpers() {

    }

    public static void showButtonDialog(Activity activity,
                                        String title,
                                        String message,
                                        String positiveButtonText,
                                        String negativeButtonText,
                                        String neutralButtonText,
                                        @StyleRes int styleId,
                                        Boolean cancelable,
                                        ButtonClickListener buttonClickListener) {

        RDADialog rdaDialog = new RDADialog(activity);

        rdaDialog.setButtonListener(buttonClickListener);

        if (cancelable != null) {

            rdaDialog.setCancelable(cancelable);

            rdaDialog.setCanceledOnTouchOutside(cancelable);
        }

        if (title != null) {

            rdaDialog.setTitle(title);
        }

        if (message != null) {

            rdaDialog.setBody(message);
        }

        if (positiveButtonText != null) {

            rdaDialog.setPositiveButton(positiveButtonText);
        }

        if (negativeButtonText != null) {

            rdaDialog.setNegativeButton(negativeButtonText);
        }

        if (neutralButtonText != null) {

            rdaDialog.setNeutralButton(neutralButtonText);
        }

        if (styleId != 0) {

            rdaDialog.getWindow().getAttributes().windowAnimations = styleId;
        }

        rdaDialog.show();
    }
}
