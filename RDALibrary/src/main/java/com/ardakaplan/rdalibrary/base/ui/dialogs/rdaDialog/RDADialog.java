package com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.ardakaplan.rdalibrary.R;
import com.ardakaplan.rdalibrary.base.ui.views.fontables.RDATextView;

/**
 * Created by Arda Kaplan on 04.12.2016 - 06:49
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

@SuppressWarnings("unused")
public class RDADialog extends Dialog {

    private ButtonClickListener buttonClickListener = null;
    //
    private Activity activity;
    //
    private Boolean dontAskMeBoolean = null;


    public RDADialog(Activity activity) {
        super(activity);

        this.activity = activity;

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(R.layout.rda_dialog);

        //noinspection ConstantConditions
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

//        this.setCanceledOnTouchOutside(false);
//
//        this.setCancelable(false);
    }

    @SuppressWarnings("UnusedReturnValue")
    public RDADialog setButtonListener(ButtonClickListener buttonClickListener) {

        this.buttonClickListener = buttonClickListener;

        return this;
    }


    public Activity getActivity() {
        return activity;
    }


    @Override
    public void setTitle(CharSequence titleText) {

        RDATextView titleTextView = findViewById(R.id.rdaDialog_textview_title);

        titleTextView.setVisibility(View.VISIBLE);

        titleTextView.setText(titleText);
    }

    @Override
    public void setTitle(int titleTextId) {

        setTitle(activity.getString(titleTextId));
    }

    public RDADialog setBody(@StringRes int bodyTextID) {

        return setBody(activity.getString(bodyTextID));
    }

    public RDADialog setBody(String bodyText) {

        RDATextView bodyRdaTextView = findViewById(R.id.rdaDialog_textview_body);

        bodyRdaTextView.setText(bodyText);

        bodyRdaTextView.setVisibility(View.VISIBLE);

        bodyRdaTextView.setMovementMethod(new ScrollingMovementMethod());

        return this;
    }

    public RDADialog setPositiveButton(@StringRes int positiveButtonTextID) {

        return setPositiveButton(getActivity().getString(positiveButtonTextID));
    }

    public RDADialog setPositiveButton(String positiveButtonText) {

        RDATextView positiveTextView = findViewById(R.id.rdaDialog_textview_positive);

        positiveTextView.setText(positiveButtonText);

        positiveTextView.setVisibility(View.VISIBLE);

        positiveTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonClickListener.onClick(RDADialog.this, ButtonType.POSITIVE);
            }
        });

        return this;
    }

    public RDADialog setNegativeButton(@StringRes int negativeButtonTextID) {

        return setNegativeButton(getActivity().getString(negativeButtonTextID));
    }

    public RDADialog setNegativeButton(String negativeButtonText) {

        RDATextView negativeTextView = findViewById(R.id.rdaDialog_textview_negative);

        negativeTextView.setVisibility(View.VISIBLE);

        negativeTextView.setText(negativeButtonText);

        negativeTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonClickListener.onClick(RDADialog.this, ButtonType.NEGATIVE);
            }
        });

        return this;
    }

    public RDADialog setNeutralButton(@StringRes int negativeButtonTextID) {

        return setNeutralButton(getActivity().getString(negativeButtonTextID));
    }

    public RDADialog setNeutralButton(String neutralButtonText) {

        RDATextView neutralTextView = findViewById(R.id.rdaDialog_textview_neutral);

        neutralTextView.setVisibility(View.VISIBLE);

        neutralTextView.setText(neutralButtonText);

        neutralTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonClickListener.onClick(RDADialog.this, ButtonType.NEUTRAL);
            }
        });

        return this;
    }

    public static void showDialog(Activity activity,
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