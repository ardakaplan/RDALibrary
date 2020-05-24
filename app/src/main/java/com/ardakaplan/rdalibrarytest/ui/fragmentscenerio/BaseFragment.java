package com.ardakaplan.rdalibrarytest.ui.fragmentscenerio;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAFragment;
import com.ardakaplan.rdalibrary.helpers.RDAFragmentHelpers;
import com.ardakaplan.rdalibrarytest.R;

/**
 * Created by Arda Kaplan at 22-Apr-20 - 15:57
 * <p>
 * ardakaplan101@gmail.com
 */
public abstract class BaseFragment extends RDAFragment {

    private RDAFragmentHelpers rdaFragmentHelpers = new RDAFragmentHelpers();

    @Override
    public RDAFragmentHelpers getFragmentHelpers() {
        return rdaFragmentHelpers;
    }

    @Override
    public int fragmentPartContainerId() {
        return R.id.mainActivity_linearLayout_fragmentPart;
    }
}
