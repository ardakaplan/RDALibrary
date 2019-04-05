package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.base.ui.screen.RDAPresenterContract;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAViewContract;

class SplashContract {

    interface SplashViewContract extends RDAViewContract {


    }

    interface SplashPresenterContract extends RDAPresenterContract<SplashViewContract> {

    }
}
