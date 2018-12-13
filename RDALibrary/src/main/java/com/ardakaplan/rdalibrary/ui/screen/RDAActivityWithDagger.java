package com.ardakaplan.rdalibrary.ui.screen;

import android.os.Bundle;
import android.support.annotation.Nullable;

import dagger.android.AndroidInjection;

public abstract class RDAActivityWithDagger extends RDAActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState, int layoutId) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState, layoutId);
    }
}
