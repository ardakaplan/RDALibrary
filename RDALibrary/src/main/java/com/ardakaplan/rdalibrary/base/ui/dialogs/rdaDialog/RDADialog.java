package com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by Arda Kaplan on 04.12.2016 - 06:49
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

@SuppressWarnings({"unused", "WeakerAccess"})
public class RDADialog extends Dialog {

    private ButtonClickListener buttonClickListener = null;
    //
    private Activity activity;
    //
    private Boolean dontAskMeBoolean = null;

    protected static @LayoutRes
    int dialogLayoutId;
    protected static @IdRes
    int dialogTitleTextViewId;
    protected static @IdRes
    int dialogMessageTextViewId;
    protected static @IdRes
    int dialogPositiveButtonTextViewId;
    protected static @IdRes
    int dialogNegativeButtonTextViewId;
    protected static @IdRes
    int dialogNeutralTextViewId;
    protected static @IdRes
    int dialogImageViewId;

    public ImageView iconImageView;
    public TextView titleTextView;
    public TextView messageTextView;
    public TextView positiveTextView;
    public TextView negativeTextView;
    public TextView neutralTextView;

    public static void registerIds(@LayoutRes int dialogLayoutIdd, @IdRes int dialogTitleTextViewIdd, @IdRes int dialogMessageTextViewIdd, @IdRes int dialogPositiveButtonTextViewIdd, @IdRes int dialogNegativeButtonTextViewIdd, @IdRes int dialogNeutralTextViewIdd, @IdRes int dialogImageViewIdd) {
        dialogLayoutId = dialogLayoutIdd;
        dialogTitleTextViewId = dialogTitleTextViewIdd;
        dialogMessageTextViewId = dialogMessageTextViewIdd;
        dialogPositiveButtonTextViewId = dialogPositiveButtonTextViewIdd;
        dialogNegativeButtonTextViewId = dialogNegativeButtonTextViewIdd;
        dialogNeutralTextViewId = dialogNeutralTextViewIdd;
        dialogImageViewId = dialogImageViewIdd;
    }

    public RDADialog(Activity activity, @StyleRes int dialogTheme) {

        super(activity, dialogTheme);

        init(activity);
    }

    public RDADialog(Activity activity) {

        super(activity);

        init(activity);
    }

    private void init(Activity activity) {

        this.activity = activity;

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(dialogLayoutId);

        //noinspection ConstantConditions
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        initViews();
    }

    private void initViews() {

        titleTextView = findViewById(dialogTitleTextViewId);

        messageTextView = findViewById(dialogMessageTextViewId);

        iconImageView = findViewById(dialogImageViewId);

        positiveTextView = findViewById(dialogPositiveButtonTextViewId);

        negativeTextView = findViewById(dialogNegativeButtonTextViewId);

        neutralTextView = findViewById(dialogNeutralTextViewId);
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

        messageTextView.setText(bodyText);

        messageTextView.setVisibility(View.VISIBLE);

        messageTextView.setMovementMethod(new ScrollingMovementMethod());

        return this;
    }

    public void setImageView(@DrawableRes int drawableId) {

        iconImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), drawableId));
    }

    public RDADialog setPositiveButton(@StringRes int positiveButtonTextID) {

        return setPositiveButton(getActivity().getString(positiveButtonTextID));
    }

    public RDADialog setPositiveButton(String positiveButtonText) {

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
                                  @StyleRes int dialogTheme,
                                  String title,
                                  String message,
                                  String positiveButtonText,
                                  String negativeButtonText,
                                  String neutralButtonText,
                                  @StyleRes int styleId,
                                  Boolean cancelable,
                                  ButtonClickListener buttonClickListener) {

        RDADialog rdaDialog;

        if (dialogTheme == 0) {

            rdaDialog = new RDADialog(activity);

        } else {

            rdaDialog = new RDADialog(activity, dialogTheme);
        }

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

            Objects.requireNonNull(rdaDialog.getWindow()).getAttributes().windowAnimations = styleId;
        }

        rdaDialog.show();
    }
}