package com.ardakaplan.rdalibrary.base.ui.screen.views;

import androidx.annotation.IdRes;

import com.ardakaplan.rdalibrary.helpers.RDAFragmentHelpers;

@SuppressWarnings("unused")
public abstract class RDAInnerFragment extends RDAFragment {

    //FragmentManager.OnBackStackChangedListener yönetimi için oluşturulan id, manager dışında kesinlikle kullanılmaması lazım
    public int ID = 0;

    protected String rdaTag = this.getClass().getSimpleName();

    public String getRdaTag() {
        return rdaTag;
    }

    public void open(RDAActivity rdaActivity) {

        open(rdaActivity, false);
    }

    public void open(RDAActivity rdaActivity, boolean clearBackStack) {

        if (rdaActivity != null) {

            getFragmentHelpers().addFragmentToBackStack(rdaActivity, this, fragmentPartContainerId(), clearBackStack);
        }
    }

    public abstract RDAFragmentHelpers getFragmentHelpers();

    public abstract @IdRes
    int fragmentPartContainerId();
}