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
import android.widget.TextView;

/**
 * Created by Arda Kaplan on 04.12.2016 - 06:49
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

@SuppressWarnings({"unused", "WeakerAccess", "JavaDoc"})
public class RDADialog extends Dialog {

    private RDAButtonClickListener RDAButtonClickListener = null;
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
    protected static @StyleRes
    int dialogStyleId;

    public ImageView iconImageView;
    public TextView titleTextView;
    public TextView messageTextView;
    public TextView positiveTextView;
    public TextView negativeTextView;
    public TextView neutralTextView;

    /**
     * send 0(zero) for unused fields
     *
     * @param dialogStyleIdd
     * @param dialogLayoutIdd
     * @param dialogTitleTextViewIdd
     * @param dialogMessageTextViewIdd
     * @param dialogPositiveButtonTextViewIdd
     * @param dialogNegativeButtonTextViewIdd
     * @param dialogNeutralTextViewIdd
     * @param dialogImageViewIdd
     */
    public static void registerIds(
            @StyleRes int dialogStyleIdd,
            @LayoutRes int dialogLayoutIdd,
            @IdRes int dialogTitleTextViewIdd,
            @IdRes int dialogMessageTextViewIdd,
            @IdRes int dialogPositiveButtonTextViewIdd,
            @IdRes int dialogNegativeButtonTextViewIdd,
            @IdRes int dialogNeutralTextViewIdd,
            @IdRes int dialogImageViewIdd) {
        dialogStyleId = dialogStyleIdd;
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

        if (dialogStyleId != 0) {

            getWindow().getAttributes().windowAnimations = dialogStyleId;
        }

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
    public RDADialog setButtonListener(RDAButtonClickListener RDAButtonClickListener) {

        this.RDAButtonClickListener = RDAButtonClickListener;

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

                RDAButtonClickListener.onClick(RDADialog.this, RDADialogButtonType.POSITIVE);
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

                RDAButtonClickListener.onClick(RDADialog.this, RDADialogButtonType.NEGATIVE);
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

                RDAButtonClickListener.onClick(RDADialog.this, RDADialogButtonType.NEUTRAL);
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
                                  Boolean cancelable,
                                  RDAButtonClickListener RDAButtonClickListener) {

        RDADialog rdaDialog;

        if (dialogStyleId == 0) {

            rdaDialog = new RDADialog(activity);

        } else {

            rdaDialog = new RDADialog(activity, dialogStyleId);
        }

        rdaDialog.setButtonListener(RDAButtonClickListener);

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

        rdaDialog.show();
    }
}