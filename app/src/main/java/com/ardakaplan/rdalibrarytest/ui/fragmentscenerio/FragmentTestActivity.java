package com.ardakaplan.rdalibrarytest.ui.fragmentscenerio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAActivity;
import com.ardakaplan.rdalibrarytest.R;

/**
 * Created by Arda Kaplan at 22-Apr-20 - 15:55
 * <p>
 * ardakaplan101@gmail.com
 */
public class FragmentTestActivity extends RDAActivity {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_activity;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.fragmentActivit_button_a).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new FragmentA().open(FragmentTestActivity.this);
            }
        });

        findViewById(R.id.fragmentActivit_button_b).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new FragmentB().open(FragmentTestActivity.this);
            }
        });

        findViewById(R.id.fragmentActivit_button_c).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new FragmentC().open(FragmentTestActivity.this);
            }
        });
    }
}
