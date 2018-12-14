package com.ardakaplan.rdalibrary.base.ui.screen;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ardakaplan.rdalogger.RDALogger;

import dagger.android.AndroidInjection;

@SuppressWarnings("unused")
public abstract class RDAActivity extends AppCompatActivity {

    protected String className;

    private boolean onScreen = false;

    protected RDAActivity() {

        className = getClass().getSimpleName();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);

        RDALogger.logLifeCycle(className);
    }

    protected void onCreate(Bundle savedInstanceState, int layoutId) {

        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);

        setContentView(layoutId);

        RDALogger.logLifeCycle(className);
    }

    protected void changeStatusBarColor(@ColorRes int colorId) {

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
