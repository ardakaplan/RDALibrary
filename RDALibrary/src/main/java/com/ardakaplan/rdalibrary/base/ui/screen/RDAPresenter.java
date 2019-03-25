package com.ardakaplan.rdalibrary.base.ui.screen;

public abstract class RDAPresenter<RView extends RDAViewContract> implements RDAPresenterContract<RView> {

    private RView rView;

    public RDAPresenter() {

    }

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
