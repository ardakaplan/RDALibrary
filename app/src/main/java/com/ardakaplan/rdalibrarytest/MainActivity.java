package com.ardakaplan.rdalibrarytest;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.ardakaplan.rdalogger.RDALogger;
import com.ardakaplan.rdalibrary.ui.screen.RDAActivity;

public class MainActivity extends RDAActivity {

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        logTest();
    }

    private void logTest() {

        Person person = new Person("Arda", "Kaplan");

        RDALogger.info(person);
    }
}
