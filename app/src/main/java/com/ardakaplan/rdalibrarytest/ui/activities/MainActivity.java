package com.ardakaplan.rdalibrarytest.ui.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.ardakaplan.rdalibrarytest.R;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

    }

    @OnClick(R.id.main_button_recyclerview)
    void openRecyclerView() {

        startActivity(new Intent(this, RecyclerActivity.class));
    }
}
