package com.ardakaplan.rdalibrary.base.ui.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatSpinner;

/**
 * Created by ardakaplan on 31/05/16.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings({"unused", "ConstantConditions"})
public class RDASpinner extends AppCompatSpinner {

    public RDASpinner(Context context) {
        super(context);
    }

    public RDASpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RDASpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setSelection(int position, boolean animate) {

        boolean sameSelected = position == getSelectedItemPosition();

        super.setSelection(position, animate);

        if (sameSelected) {
            // Spinner does not call the OnItemSelectedListener if the same item is selected, so do it manually now
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }

    @Override
    public void setSelection(int position) {

        boolean sameSelected = position == getSelectedItemPosition();

        super.setSelection(position);

        if (sameSelected) {
            // Spinner does not call the OnItemSelectedListener if the same item is selected, so do it manually now
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }
}
