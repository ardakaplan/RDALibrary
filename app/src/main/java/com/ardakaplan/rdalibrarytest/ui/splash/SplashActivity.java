package com.ardakaplan.rdalibrarytest.ui.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalibrary.domain.interaction.RDAInteractionException;
import com.ardakaplan.rdalibrary.helpers.RDAApplicationHelpers;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.managers.storage.StorageManager;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.OnClick;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @Inject
    RDAApplicationHelpers rdaApplicationHelpers;

    @Inject
    StorageManager storageManager;

    @Override
    protected void adjustApplicationTheme() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.activity_splash);

        presenter.attach(this);

        presenter.testPresenterContract();

        presenter.getList();

        RDALogger.info("VERSION CODE : " + rdaApplicationHelpers.getAppVersionCode());

        RDALogger.info("SHARED : " + storageManager.getSharedManager().getUsername());

        storageManager.getSharedManager().saveUsername("HAAAAAAAAAAAAAA");

        RDALogger.info("SHARED : " + storageManager.getSharedManager().getUsername());
    }

    @OnClick(R.id.button_test)
    void test() {

        RDALogger.info("TEST");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }

    @Override
    public void testViewContract() {

    }

    @Override
    public void setList(ArrayList<String> list) {

//        for (String s : list) {
//
//            RDALogger.info(s);
//        }
    }

    @Override
    public void onError(RDAInteractionException e) {

        e.printStackTrace();

        Toast.makeText(this, "HATA", Toast.LENGTH_SHORT).show();
    }

}
