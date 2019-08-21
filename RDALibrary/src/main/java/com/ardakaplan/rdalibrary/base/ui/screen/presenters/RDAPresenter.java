package com.ardakaplan.rdalibrary.base.ui.screen.presenters;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAViewContract;

public abstract class RDAPresenter<RView extends RDAViewContract> implements RDAPresenterContract<RView> {

    private RView rView;

    protected RView getView() {
        return rView;
    }

    public final void attach(RView rView) {
        this.rView = rView;

        onAttached();
    }

    public final void detach() {
        rView = null;

        onDetached();
    }

    protected abstract void onAttached();

    protected abstract void onDetached();
}
