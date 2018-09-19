package com.ardakaplan.rdalibrary.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;

import com.ardakaplan.rdalibrary.R;


@SuppressWarnings({"WeakerAccess", "unused", "DeprecatedIsStillUsed"})
public class RDAProgressDialog extends Dialog {

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
    }
}
