package com.ardakaplan.rdalibrarytest.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalibrary.ui.screen.RDAActivity;

import butterknife.ButterKnife;

/**
 * Created by Arda Kaplan on 19.09.2018 - 15:26
 */
public abstract class BaseActivity extends RDAActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState, int layoutId) {
        super.onCreate(savedInstanceState, layoutId);

        ButterKnife.bind(this);
    }
}
