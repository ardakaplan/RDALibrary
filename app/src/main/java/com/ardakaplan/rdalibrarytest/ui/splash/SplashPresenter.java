package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.objects.base.RDAPresenter;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;

public class SplashPresenter extends RDAPresenter<SplashContract.SplashViewContract> implements SplashContract.SplashPresenterContract {


    @Inject
    public SplashPresenter() {

    }


    @Override
    protected void onAttached() {

    }

    @Override
    protected void onDetached() {

    }

    @Override
    public void testPresenterContract() {

        RDALogger.info("SPLASH PRESENTER ÇALIŞTI");
    }
}
