package com.ardakaplan.rdalibrary.base.ui.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Arda Kaplan on 12-Apr-19 - 11:04
 */
public class ContinuousClickLinearLayout extends LinearLayout {

    private static final int CLICK_COUNT_THRESHOLD = 5;
    private static final long INITIAL_CLICK_PERIOD = 250;

    //default is true, but you can set
    private boolean repeatedClick = true;

    private boolean autoClick = false;

    private int clickCountBeforeAcceleration = CLICK_COUNT_THRESHOLD;

    private long clickPeriod = INITIAL_CLICK_PERIOD;

    private Timer timer = null;


    public ContinuousClickLinearLayout(Context context) {
        super(context);
    }

    public ContinuousClickLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ContinuousClickLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ContinuousClickLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            if ((isClickable() || hasOnClickListeners()) && repeatedClick) {

                autoClick = true;

                timer = new Timer();

                timer.schedule(new Clicker(), INITIAL_CLICK_PERIOD);

                return true;
            }
            
        } else if (event.getAction() == MotionEvent.ACTION_UP) {

            if (repeatedClick) {

                resetClickValues();

                performClick();
            }

        } else if (event.getAction() == MotionEvent.ACTION_CANCEL) {

            if (repeatedClick) {

                resetClickValues();
            }
        }

        return super.onTouchEvent(event);
    }

    private void resetClickValues() {

        if (timer != null) {

            timer.cancel();
        }
        autoClick = false;

        clickPeriod = INITIAL_CLICK_PERIOD;

        clickCountBeforeAcceleration = CLICK_COUNT_THRESHOLD;
    }

    public void setRepeatedClick(boolean repeatedClick) {
        this.repeatedClick = repeatedClick;
    }


    private class Clicker extends TimerTask {

        @Override
        public void run() {

            if (autoClick) {

                ContinuousClickLinearLayout.this.post(new Runnable() {

                    @Override
                    public void run() {

                        performClick();
                    }
                });

                if (--clickCountBeforeAcceleration == 0) {

                    clickCountBeforeAcceleration = CLICK_COUNT_THRESHOLD;

                    clickPeriod -= 50;

                    if (clickPeriod < 50) {

                        clickPeriod = 50;
                    }
                }

                ContinuousClickLinearLayout.this.postDelayed(new Clicker(), clickPeriod);
            }
        }
    }
}
