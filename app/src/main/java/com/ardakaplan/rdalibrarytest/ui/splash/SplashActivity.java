package com.ardakaplan.rdalibrarytest.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalibrary.ui.screen.RDAActivityWithDagger;
import com.ardakaplan.rdalibrarytest.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class SplashActivity extends RDAActivityWithDagger implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        presenter.attach(this);


        presenter.testPresenterContract();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }

    @Override
    public void testViewContract() {

    }

}
