package com.ardakaplan.rdalibrarytest.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalibrary.helpers.RDANotificationHelper;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.ui.activities.MainActivity;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.Timer;
import java.util.TimerTask;

public class BackgroundService extends IntentService {

    private int index = 0;

    public BackgroundService() {
        super("BACKGROUND_SERVICE");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                RDALogger.info("ÇALIŞYIOR ");

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);


                index++;

                RDANotificationHelper.showNotification(getApplicationContext(),
                        intent,
                        "TITLE",
                        "TEXT" + index,
                        R.mipmap.ic_launcher,
                        true,
                        false,
                        false,
                        false,
                        1,
                        "CHJANNEL",
                        "CAHNNEL ID", RDANotificationHelper.Importance.IMPORTANCE_DEFAULT);

            }
        }, 1000, 1000);
    }

}
