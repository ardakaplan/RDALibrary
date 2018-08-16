package com.ardakaplan.rdalibrary.ui.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;

import com.ardakaplan.rdalibrary.R;


@SuppressWarnings({"WeakerAccess", "unused", "DeprecatedIsStillUsed"})
public class RDAProgressDialog extends Dialog {

    protected static RDAProgressDialog progressDialog;

    public RDAProgressDialog(Context context) {

        this(context, R.layout.popup_progress);
    }


    public RDAProgressDialog(Context context, int layoutID) {

        super(context);

        this.setCancelable(false);

        this.setCanceledOnTouchOutside(false);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(layoutID);

        //noinspection ConstantConditions
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        progressDialog = this;
    }

    @SuppressWarnings("deprecation")
    public static void open(Activity activity) {

        if (progressDialog != null) {

            progressDialog.dismiss();
        }

        new RDAProgressDialog(activity).show();
    }

    public static void close() {

        if (progressDialog != null) {

            progressDialog.dismiss();
        }
    }

    @Override
    @Deprecated
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {

        try {

            super.dismiss();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        progressDialog = null;
    }


}
