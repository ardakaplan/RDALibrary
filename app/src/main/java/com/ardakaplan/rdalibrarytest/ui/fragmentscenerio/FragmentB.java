package com.ardakaplan.rdalibrarytest.ui.fragmentscenerio;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrarytest.R;

/**
 * Created by Arda Kaplan at 22-Apr-20 - 15:57
 * <p>
 * ardakaplan101@gmail.com
 */
public class FragmentB extends BaseFragment {

    @Override
    public int getLayout() {
        return R.layout.fragment_b;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }
}
