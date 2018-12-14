package com.ardakaplan.rdalibrarytest.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalibrary.domain.interaction.InteractionException;
import com.ardakaplan.rdalibrary.helpers.RDAApplicationHelpers;
import com.ardakaplan.rdalibrary.helpers.RDASharedHelpers;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.ArrayList;

import javax.inject.Inject;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @Inject
    RDAApplicationHelpers rdaApplicationHelpers;

    @Inject
    RDASharedHelpers rdaSharedHelpers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        presenter.attach(this);

        presenter.testPresenterContract();

        presenter.getList();

        RDALogger.info("VERSION CODE : " + rdaApplicationHelpers.getAppVersionCode());

        RDALogger.info("SHARED : " + rdaSharedHelpers.getBoolean("ARDA"));
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
    public void onError(InteractionException e) {

        e.printStackTrace();

        Toast.makeText(this, "HATA", Toast.LENGTH_SHORT).show();
    }

}
