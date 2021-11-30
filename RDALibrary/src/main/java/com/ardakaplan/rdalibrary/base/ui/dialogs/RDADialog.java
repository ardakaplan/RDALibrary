package com.ardakaplan.rdalibrary.base.ui.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.ardakaplan.rdalibrary.base.ui.screen.ViewController;
import com.ardakaplan.rdalibrary.helpers.RDADeviceHelpers;
import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;
import com.ardakaplan.rdalibrary.helpers.RDAViewHelpers;

import butterknife.ButterKnife;

/**
 * Created by Arda Kaplan at 31-May-20 - 13:13
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class RDADialog extends Dialog implements ViewController {

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

        ButterKnife.bind(this, this);
    }

    @Override
    public void closeKeyboard() {

        RDADeviceHelpers.closeKeyboard(getOwnerActivity());
    }

    @Override
    public boolean isEditTextFilled(EditText editText) {
        return RDAStringHelpers.isFilled(getPureText(editText));
    }

    @Override
    public boolean isEditTextEmpty(EditText editText) {
        return RDAStringHelpers.isEmpty(getPureText(editText));
    }

    @Override
    public String getPureText(EditText editText) {
        return RDAViewHelpers.getPureText(editText);
    }
}
