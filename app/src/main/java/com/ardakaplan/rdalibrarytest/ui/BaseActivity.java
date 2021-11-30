package com.ardakaplan.rdalibrarytest.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAActivity;

import butterknife.ButterKnife;

/**
 * Created by Arda Kaplan at 11-Apr-20
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class BaseActivity extends RDAActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }
}
