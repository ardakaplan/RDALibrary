package com.ardakaplan.rdalibrary.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;

import com.ardakaplan.rdalibrary.R;


@SuppressWarnings({"WeakerAccess", "unused", "DeprecatedIsStillUsed"})
public abstract class RDAProgressDialog extends Dialog {

    protected ProgressBar progressBar;

    public RDAProgressDialog(Context context) {

        this(context, R.layout.dialog_rda_progress);
    }

    public RDAProgressDialog(Context context, int layoutID) {

        super(context);

        setCancelable(false);

        setCanceledOnTouchOutside(false);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(layoutID);

        progressBar = findViewById(R.id.dialogProgress_progressBar);

        //noinspection ConstantConditions
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }
}
