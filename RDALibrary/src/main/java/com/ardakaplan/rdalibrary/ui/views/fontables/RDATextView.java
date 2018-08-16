package com.ardakaplan.rdalibrary.ui.views.fontables;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by ardakaplan on 09/11/15.
 */
@SuppressWarnings("unused")
public class RDATextView extends android.support.v7.widget.AppCompatTextView {


    public RDATextView(Context context) {
        super(context);
    }

    public RDATextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Fonts.setFont(this, context, attrs, isInEditMode());
    }

    public RDATextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Fonts.setFont(this, context, attrs, isInEditMode());
    }
}