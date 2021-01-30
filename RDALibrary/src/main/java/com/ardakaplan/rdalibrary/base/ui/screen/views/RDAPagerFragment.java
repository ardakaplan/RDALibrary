package com.ardakaplan.rdalibrary.base.ui.screen.views;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.helpers.RDAFragmentHelpers;

/**
 * Created by Arda Kaplan at 30.01.2021 - 21:38
 * <p>
 * ardakaplan101@gmail.com
 */
public class RDAPagerFragment extends RDAFragment{

    @Override
    public RDAFragmentHelpers getFragmentHelpers() {
        return null;
    }

    @Override
    public int fragmentPartContainerId() {
        return 0;
    }



    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }
}
