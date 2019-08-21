package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAViewContract;

class SplashContract {

    interface SplashViewContract extends RDAViewContract {


    }

    interface SplashPresenterContract extends RDAPresenterContract<SplashViewContract> {

    }
}
