package com.ardakaplan.rdalibrary.base.ui.screen.views;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.objects.RDAApplication;
import com.ardakaplan.rdalibrary.base.ui.screen.screencontracts.ActivityContract;
import com.ardakaplan.rdalibrary.helpers.RDAFragmentHelpers;
import com.ardakaplan.rdalibrary.managers.LanguageManager;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.Locale;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

@SuppressWarnings("unused")
public abstract class RDAActivity extends DaggerAppCompatActivity implements RDAViewContract, ActivityContract {

    protected String className;

    private boolean onScreen = false;

    protected RDAActivity() {

        className = getClass().getSimpleName();
    }

    private void checkLanguageAndChange() {

        LanguageManager.Language selectedLanguage = ((RDAApplication) getApplication()).getSelectedLanguage();

        Configuration configuration = getResources().getConfiguration();

        Locale.setDefault(selectedLanguage.getLocale());

        Configuration config = new Configuration();

        config.locale = selectedLanguage.getLocale();

        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        checkLanguageAndChange();

        RDALogger.logLifeCycle(className);

        setContentView(getLayout());

        ButterKnife.bind(this);

        if (getPresenterContract() != null) {

            //noinspection unchecked
            getPresenterContract().attach(this);
        }
    }

//    protected void onCreate(Bundle savedInstanceState, int layoutId) {
//
//        super.onCreate(savedInstanceState);
//
//        setContentView(layoutId);
//
//        ButterKnife.bind(this);
//
//        RDALogger.logLifeCycle(className);
//    }

    @Override
    public void changeStatusBarColor(@ColorRes int colorId) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().setStatusBarColor(getActivity().getResources().getColor(colorId));
        }
    }

    @SuppressWarnings("unused")
    public boolean isOnScreen() {
        return onScreen;
    }

    protected RDAActivity getActivity() {
        return this;
    }

    @Override
    protected void onResume() {
        super.onResume();

        onScreen = true;

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onDestroy() {

        if (getPresenterContract() != null) {

            getPresenterContract().detach();
        }

        super.onDestroy();

        onScreen = false;

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onPause() {
        super.onPause();

        onScreen = false;

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onStart() {
        super.onStart();

        RDALogger.logLifeCycle(className);
    }

    @Override
    protected void onStop() {
        super.onStop();

        onScreen = false;

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onBackPressed() {

        RDAFragment currentFragment = RDAFragmentHelpers.getCurrentFragment(this);

        if (currentFragment != null && currentFragment.getOnBackPressControl()) {

            currentFragment.onBackPressed();

        } else {

            super.onBackPressed();
        }
    }

    public void directOnBackPressed() {
        super.onBackPressed();
    }
}
