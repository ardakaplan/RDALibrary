package com.ardakaplan.rdalibrary.base.ui.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Arda Kaplan at 12/19/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public class RDATabView extends LinearLayout {


    public RDATabView(Context context) {
        super(context);
    }

    public RDATabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RDATabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RDATabView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);

        for (int i = 0; i < getChildCount(); i++) {

            getChildAt(i).setSelected(selected);
        }
    }
}
