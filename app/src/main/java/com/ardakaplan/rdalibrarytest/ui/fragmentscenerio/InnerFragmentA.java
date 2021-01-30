package com.ardakaplan.rdalibrarytest.ui.fragmentscenerio;

import android.os.Bundle;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrarytest.R;

/**
 * Created by Arda Kaplan at 22-Apr-20 - 15:57
 * <p>
 * ardakaplan101@gmail.com
 */
public class InnerFragmentA extends BaseInnerFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }
}
