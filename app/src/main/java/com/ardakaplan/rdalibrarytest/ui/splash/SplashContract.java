package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.objects.base.RDAPresenterContract;
import com.ardakaplan.rdalibrary.objects.base.RDAViewContract;

public class SplashContract {

    public interface SplashViewContract extends RDAViewContract {

        void testViewContract();

    }

    public interface SplashPresenterContract extends RDAPresenterContract<SplashViewContract> {

        void testPresenterContract();
    }
}
