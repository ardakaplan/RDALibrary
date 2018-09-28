package com.ardakaplan.rdalibrarytest.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ardakaplan.rdalibrary.helpers.RDANotificationHelper;
import com.ardakaplan.rdalibrarytest.R;

import butterknife.BindView;

public class NotificationActivity extends BaseActivity {

    @BindView(R.id.notificaiton_linearlayout_root)
    LinearLayout rootLinearlayout;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_notification);

        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        RDANotificationHelper.showNotification(getApplicationContext(),
                intent,
                "TITLE",
                "IMPORTANCE MAX",
                R.mipmap.ic_launcher,
                true,
                false,
                false,
                false,
                1,
                "CHJANNEL",
                "CAHNNEL ID", RDANotificationHelper.Importance.IMPORTANCE_MAX, true);

        for (int i = 0; i < RDANotificationHelper.Importance.values().length; i++) {

            Button button = new Button(this);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            button.setLayoutParams(layoutParams);

            button.setText(String.valueOf(RDANotificationHelper.Importance.values()[i]));

            final int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    RDANotificationHelper.showNotification(getApplicationContext(),
                            intent,
                            "TITLE",
                            RDANotificationHelper.Importance.values()[finalI].toString(),
                            R.mipmap.ic_launcher,
                            true,
                            false,
                            false,
                            false,
                            1,
                            "CHJANNEL",
                            "CAHNNEL ID", RDANotificationHelper.Importance.values()[finalI], false);
                }
            });

            rootLinearlayout.addView(button);

        }
    }
}
