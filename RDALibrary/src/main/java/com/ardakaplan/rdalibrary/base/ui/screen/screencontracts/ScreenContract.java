package com.ardakaplan.rdalibrary.base.ui.screen.screencontracts;

import com.ardakaplan.rdalibrary.base.ui.screen.ViewController;
import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;

/**
 * Created by Arda Kaplan at 21-Aug-19
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * common methods contract for activity and fragment
 */
public interface ScreenContract extends ViewController {

    /**
     * @return view presenter
     */
    RDAPresenterContract getPresenterContract();
}
