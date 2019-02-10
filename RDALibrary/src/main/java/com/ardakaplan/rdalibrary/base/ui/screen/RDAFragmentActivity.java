package com.ardakaplan.rdalibrary.base.ui.screen;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.ardakaplan.rdalibrary.helpers.RDAFragmentHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Arda Kaplan on
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

@SuppressWarnings("unused")
public abstract class RDAFragmentActivity extends FragmentActivity implements ApplicationThemeChanger, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    protected String className;

    private boolean onScreen = false;

    protected RDAFragmentActivity() {

        className = getClass().getSimpleName();
    }

    @SuppressWarnings("unused")
    public boolean isOnScreen() {
        return onScreen;
    }

    protected void onCreate(Bundle savedInstanceState, int layoutId) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);

        adjustApplicationTheme();

        setContentView(layoutId);

        ButterKnife.bind(this);

        RDALogger.logLifeCycle(className);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }

    @Override
    public void adjustApplicationTheme() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        RDAFragment currentFragment = RDAFragmentHelpers.getCurrentFragment(this);

        //is there any fragment in backstack
        if (currentFragment != null) {

            currentFragment.onActivityResult(requestCode, resultCode, data);

        } else {

            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    protected void changeStatusBarColor(@ColorRes int colorId) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().setStatusBarColor(getActivity().getResources().getColor(colorId));
        }
    }

    protected RDAFragmentActivity getActivity() {
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

}
