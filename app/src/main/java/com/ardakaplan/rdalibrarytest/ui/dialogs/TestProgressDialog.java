package com.ardakaplan.rdalibrarytest.ui.dialogs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;

import com.ardakaplan.rdalibrary.ui.dialogs.RDAProgressDialog;

/**
 * Created by Arda Kaplan on 02-Nov-18 - 15:06
 */
public class TestProgressDialog extends RDAProgressDialog {

    public TestProgressDialog(Context context) {
        super(context);

        setProgressBarColor();
    }

    public TestProgressDialog(Context context, int layoutID) {
        super(context, layoutID);

        setProgressBarColor();
    }


    private void setProgressBarColor() {

        progressBar.getIndeterminateDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
    }
}
