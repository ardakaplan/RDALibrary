package com.ardakaplan.rdalibrary.base.ui.screen.screencontracts;

import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;

/**
 * Created by Arda Kaplan at 21-Aug-19
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * common methods contract for activity and fragment
 */
public interface ScreenContract {

    /**
     * @return screen layout
     */
    @LayoutRes
    int getLayout();

    /**
     * @return view presenter
     */
    RDAPresenterContract getPresenterContract();

    void changeStatusBarColor(@ColorRes int colorId);
}
