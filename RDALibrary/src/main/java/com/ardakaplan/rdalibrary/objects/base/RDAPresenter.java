package com.ardakaplan.rdalibrary.objects.base;

public abstract class RDAPresenter<TView extends RDAViewContract> implements RDAPresenterContract<TView> {

    private TView tView;

    public RDAPresenter() {

    }

    protected TView gettView() {
        return tView;
    }

    public final void attach(TView tView) {
        this.tView = tView;

        onAttached();
    }

    public final void detach() {
        tView = null;

        onDetached();
    }

    protected abstract void onAttached();

    protected abstract void onDetached();
}
