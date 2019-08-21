package com.ardakaplan.rdalibrary.base.ui.screen.presenters;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAViewContract;

public interface RDAPresenterContract<RView extends RDAViewContract> {

    void attach(RView rView);

    void detach();
}
