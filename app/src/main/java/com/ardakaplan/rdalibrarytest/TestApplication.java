package com.ardakaplan.rdalibrarytest;

import com.ardakaplan.rdalibrary.base.objects.RDAApplication;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.RDADialog;
import com.ardakaplan.rdalibrary.di.HasCustomActivityInjector;
import com.ardakaplan.rdalibrarytest.di.AppComponent;
import com.ardakaplan.rdalibrarytest.di.DaggerAppComponent;

/**
 * Created by Arda Kaplan on 10.08.2018 - 17:44
 */
public class TestApplication extends RDAApplication implements HasCustomActivityInjector {

    @Override
    public void onCreate() {
        super.onCreate();

        initRDADialog();
    }

    @Override
    protected String getRDALoggerTag() {
        return getString(R.string.app_name);
    }

    @Override
    protected boolean doesRDALoggerWork() {
        return true;
    }

    @Override
    protected void initDagger() {

        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();

        appComponent.inject(this);
    }

    @Override
    protected void initRDADialog() {

        RDADialog.registerIds(R.layout.af_dialog, R.id.afDialog_textView_title, R.id.afDialog_textView_message, R.id.afDialog_textView_button_positive,
                R.id.afDialog_textView_button_negative, R.id.afDialog_textView_button_neutral);
    }
}
