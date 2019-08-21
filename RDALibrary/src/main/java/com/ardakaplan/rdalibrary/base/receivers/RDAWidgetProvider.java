package com.ardakaplan.rdalibrary.base.receivers;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

import dagger.android.AndroidInjection;

/**
 * Created by Arda Kaplan at 03-Aug-19
 * <p>
 * arda.kaplan09@gmail.com
 */
public class RDAWidgetProvider extends AppWidgetProvider {

    @Override
    public void onReceive(Context context, Intent intent) {
        AndroidInjection.inject(this, context);
        super.onReceive(context, intent);
    }
}
