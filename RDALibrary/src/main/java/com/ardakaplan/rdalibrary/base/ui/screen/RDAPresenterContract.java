package com.ardakaplan.rdalibrary.base.ui.screen;

public interface RDAPresenterContract<TView extends RDAViewContract> {

    void attach(TView tView);
    void detach();

}
