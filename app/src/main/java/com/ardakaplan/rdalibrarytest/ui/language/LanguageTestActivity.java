package com.ardakaplan.rdalibrarytest.ui.language;

import android.widget.Toast;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.helpers.RDAIntentHelpers;
import com.ardakaplan.rdalibrary.managers.RDALanguageManager;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.di.LanguageModule;
import com.ardakaplan.rdalibrarytest.ui.BaseActivity;
import com.ardakaplan.rdalibrarytest.ui.splash.SplashActivity;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 4/6/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public class LanguageTestActivity extends BaseActivity {

    @Inject
    RDALanguageManager RDALanguageManager;

    @Inject
    RDAIntentHelpers rdaIntentHelpers;

    @OnClick(R.id.language_test_activity_button_getSelectedLanguage)
    void clickedGetSelectedLanguage() {

        Toast.makeText(this, RDALanguageManager.getSelectedLanguage().getScreenName(), Toast.LENGTH_SHORT).show();

        RDALogger.info("SELECTED LANGUAGE -> " + RDALanguageManager.getSelectedLanguage().getScreenName());
    }

    @OnClick(R.id.language_test_activity_button_turkish)
    void clickedTurkish() {

        RDALanguageManager.saveNewSelectedLanguage(LanguageModule.TURKISH);

        startActivity(rdaIntentHelpers.getClearCacheIntent(SplashActivity.class));
    }

    @OnClick(R.id.language_test_activity_button_english)
    void clickedEnglish() {

        RDALanguageManager.saveNewSelectedLanguage(LanguageModule.ENGLISH);

        startActivity(rdaIntentHelpers.getClearCacheIntent(SplashActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_language_test;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }
}
