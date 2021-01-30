package com.ardakaplan.rdalibrary.base.ui.screen;

import android.widget.EditText;

import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;

/**
 * Created by Arda Kaplan at 27.01.2021 - 12:24
 * <p>
 * ardakaplan101@gmail.com
 */
public interface ViewController {

    void closeKeyboard();

    boolean isEditTextFilled(EditText editText);

    boolean isEditTextEmpty(EditText editText);

    String getPureText(EditText editText);

    /**
     * @return screen layout
     */
    @LayoutRes
    int getLayoutId();

    void changeStatusBarColor(@ColorRes int colorId);
}
