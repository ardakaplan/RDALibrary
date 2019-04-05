package com.ardakaplan.rdalibrarytest.ui.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.ui.filetest.FileTestActivity;
import com.ardakaplan.rdalibrarytest.ui.language.LanguageTestActivity;

import javax.inject.Inject;

import butterknife.OnClick;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.activity_splash);

        presenter.attach(this);
    }

    @OnClick(R.id.splash_activity_button_fileTest)
    void clickedFileTest() {

        startActivity(new Intent(this, FileTestActivity.class));
    }

    @OnClick(R.id.splash_activity_button_languageTest)
    void clickedLanguageTest() {

        startActivity(new Intent(this, LanguageTestActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
