package com.ardakaplan.rdalibrarytest.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.adapters.TestRecylerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Arda Kaplan on 19.09.2018 - 15:24
 */
public class RecyclerActivity extends BaseActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    ArrayList<String> list = new ArrayList<>();


    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_recyclerlist);

        for (int i = 0; i < 30; i++) {

            list.add("LINE  " + (i + 1));
        }

        recyclerView.setAdapter(new TestRecylerViewAdapter(list));
    }
}
