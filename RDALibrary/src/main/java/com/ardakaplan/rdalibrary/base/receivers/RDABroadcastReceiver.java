package com.ardakaplan.rdalibrary.base.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import dagger.android.AndroidInjection;

/**
 * Created by Arda Kaplan at 02-Aug-19
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDABroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        AndroidInjection.inject(this, context);
    }
}
