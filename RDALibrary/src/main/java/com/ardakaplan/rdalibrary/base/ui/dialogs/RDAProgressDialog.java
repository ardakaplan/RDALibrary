package com.ardakaplan.rdalibrary.base.ui.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;

import com.ardakaplan.rdalibrary.R;

@SuppressWarnings({"WeakerAccess", "unused"})
public class RDAProgressDialog extends Dialog {

    protected ProgressBar progressBar;

    public RDAProgressDialog(Activity activity) {

        this(activity, R.layout.dialog_rda_progress);
    }

    public RDAProgressDialog(Activity activity, int layoutID) {

        super(activity);

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
