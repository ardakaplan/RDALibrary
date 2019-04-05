package com.ardakaplan.rdalibrary.base.ui.screen;

public interface RDAPresenterContract<RView extends RDAViewContract> {

    void attach(RView rView);

    void detach();
}
