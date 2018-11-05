package com.ardakaplan.rdalibrary.ui.screen;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.FragmentActivity;

import com.ardakaplan.rdalogger.RDALogger;

/**
 * Created by Arda Kaplan on
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

@SuppressWarnings("unused")
public abstract class RDAFragmentActivity extends FragmentActivity {

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
        super.onCreate(savedInstanceState);

        setContentView(layoutId);

        RDALogger.logLifeCycle(className);
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
