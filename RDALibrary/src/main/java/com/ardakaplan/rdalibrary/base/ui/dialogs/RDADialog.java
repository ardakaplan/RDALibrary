package com.ardakaplan.rdalibrary.base.ui.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

/**
 * Created by Arda Kaplan at 31-May-20 - 13:13
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class RDADialog extends Dialog {

    public RDADialog(@NonNull Activity activity) {
        super(activity);

        init(activity);
    }

    public RDADialog(@NonNull Activity activity, @StyleRes int dialogStyle) {
        super(activity, dialogStyle);

        init(activity);
    }


    private void init(Activity activity) {

        setOwnerActivity(activity);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(getLayoutId());

        setCancelable(false);

        setCanceledOnTouchOutside(false);
    }

    @LayoutRes
    protected abstract int getLayoutId();
}
