package com.ardakaplan.rdalibrary.base.ui.dialogs.app_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.ardakaplan.rdalogger.RDALogger;
import com.ardakaplan.rdalibrary.base.ui.views.fontables.edittexts.OneLineRDAEditText;

/**
 * Created by Arda Kaplan on 04.12.2016 - 06:49
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class RDADialog extends Dialog {

    private RDADialogClickListener rdaDialogClickListener;

    private Activity activity;

    private Boolean dontAskMeBoolean = false;

    //views
    private TextView titleTextView;
    private TextView bodyTextView;
    private OneLineRDAEditText inputEdittext;
    private Button positiveButton;
    private Button neutralButton;
    private Button negativeButton;

    //ID's
    private static int layoutID;
    private static int titleTextViewID;
    private static int bodyTextViewID;
    private static int inputEdittextID;
    private static int positiveButtonID;
    private static int negativeButtonID;
    private static int neutralButtonID;

    //animation style ID
    private static int animationStyleID;

    public static void initRDADialog(@LayoutRes int layoutId,
                                     @IdRes int titleTextViewId,
                                     @IdRes int bodyTextViewId,
                                     @IdRes int inputEdittextId,
                                     @IdRes int positiveButtonId,
                                     @IdRes int negativeButtonId,
                                     @IdRes int neutralButtonId,
                                     @StyleRes int animationStyleId) {

        layoutID = layoutId;
        titleTextViewID = titleTextViewId;
        bodyTextViewID = bodyTextViewId;
        inputEdittextID = inputEdittextId;
        positiveButtonID = positiveButtonId;
        negativeButtonID = negativeButtonId;
        neutralButtonID = neutralButtonId;
        animationStyleID = animationStyleId;
    }

    private RDADialog(Activity activity) {
        super(activity);

        this.activity = activity;

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(layoutID);

        //noinspection ConstantConditions
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        findViews();
    }

    private void findViews() {

        if (titleTextViewID == 0) {

            RDALogger.error("Init RDADailog first !!!!");
        }

        titleTextView = findViewById(titleTextViewID);
        bodyTextView = findViewById(bodyTextViewID);
        inputEdittext = findViewById(inputEdittextID);
        positiveButton = findViewById(positiveButtonID);
        neutralButton = findViewById(neutralButtonID);
        negativeButton = findViewById(negativeButtonID);
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

    private RDADialog setBody(@StringRes int bodyTextID) {

        return setBody(activity.getString(bodyTextID));
    }

    private RDADialog setBody(String bodyText) {

        bodyTextView.setVisibility(View.VISIBLE);

        bodyTextView.setText(bodyText);

        bodyTextView.setMovementMethod(new ScrollingMovementMethod());

        return this;
    }

    private RDADialog setInputEdittext(@StringRes int inputTextID, @StringRes int inputHintID) {

        return setInputEdittext(activity.getString(inputTextID), activity.getString(inputHintID));
    }

    private RDADialog setInputEdittext(String inputText, String inputHint) {

        inputEdittext.setVisibility(View.VISIBLE);

        inputEdittext.setText(inputText);

        inputEdittext.setSelection(inputText.length());

        inputEdittext.setHint(inputHint);

        inputEdittext.setVisibility(View.VISIBLE);

        return this;
    }

    private RDADialog setPositiveButton(@StringRes int positiveButtonTextID) {

        return setPositiveButton(activity.getString(positiveButtonTextID));
    }

    private RDADialog setPositiveButton(String positiveButtonText) {

        positiveButton.setVisibility(View.VISIBLE);

        positiveButton.setText(positiveButtonText);

        positiveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rdaDialogClickListener.onClick(RDADialog.this, RDADialogButtonType.POSITIVE, dontAskMeBoolean, inputEdittext.getText().toString());
            }
        });

        return this;
    }

    private RDADialog setNegativeButton(@StringRes int negativeButtonTextID) {

        return setNegativeButton(activity.getString(negativeButtonTextID));
    }

    private RDADialog setNegativeButton(String negativeButtonText) {

        negativeButton.setVisibility(View.VISIBLE);

        negativeButton.setText(negativeButtonText);

        negativeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rdaDialogClickListener.onClick(RDADialog.this, RDADialogButtonType.NEGATIVE, dontAskMeBoolean, inputEdittext.getText().toString());
            }
        });

        return this;
    }

    private RDADialog setNeutralButton(@StringRes int negativeButtonTextID) {

        return setNeutralButton(activity.getString(negativeButtonTextID));
    }

    private RDADialog setNeutralButton(String neutralButtonText) {

        neutralButton.setVisibility(View.VISIBLE);

        neutralButton.setText(neutralButtonText);

        neutralButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rdaDialogClickListener.onClick(RDADialog.this, RDADialogButtonType.NEUTRAL, dontAskMeBoolean, inputEdittext.getText().toString());
            }
        });

        return this;
    }

    private RDADialog setButtonClickListener(RDADialogClickListener baseButtonClickListener) {

        this.rdaDialogClickListener = baseButtonClickListener;

        return this;
    }


    public static void showDialog(Activity activity,
                                  boolean cancelable,
                                  boolean cancelableOnTouchOutside,
                                  String title,
                                  String body,
                                  String positiveButtonText,
                                  String negativeButtonText,
                                  String neutralButtonText,
                                  String inputText,
                                  String inputHint,
                                  RDADialogClickListener baseButtonClickListener) {

        RDADialog rdaDialog = new RDADialog(activity);

        rdaDialog.setCancelable(cancelable);

        rdaDialog.setCanceledOnTouchOutside(cancelableOnTouchOutside);

        if (title != null) {

            rdaDialog.setTitle(title);
        }

        if (body != null) {

            rdaDialog.setBody(body);
        }

        if (inputText != null) {

            rdaDialog.setInputEdittext(inputText, inputHint == null ? "" : inputHint);
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

        rdaDialog.setButtonClickListener(baseButtonClickListener);

        //noinspection ConstantConditions
        rdaDialog.getWindow().getAttributes().windowAnimations = animationStyleID;

        rdaDialog.show();
    }

    ////////////////////////////////////////////////////////////////////

//    private RDADialog setButtonListener(RDADialogClickListener buttonClickListenerDontAskMeAgain) {
//
//        LinearLayout dontAskMeAgainLinearLayout = findViewById(R.id.app_dialog_linearlayout_dont_show_me_again);
//
//        dontAskMeAgainLinearLayout.setVisibility(View.VISIBLE);
//
//        final ImageView dontAskMeImageView = findViewById(R.id.app_dialog_imageview_dont_show_me_again);
//
//        dontAskMeBoolean = false;
//
//        dontAskMeAgainLinearLayout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                if (dontAskMeBoolean) {
//
//                    dontAskMeImageView.setImageBitmap(null);
//
//                    dontAskMeBoolean = false;
//
//                } else {
//
////                    dontAskMeImageView.setImageBitmap(BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.icon_check_pink));
//
//                    dontAskMeBoolean = true;
//                }
//            }
//        });
//
//        return this;
//    }


}