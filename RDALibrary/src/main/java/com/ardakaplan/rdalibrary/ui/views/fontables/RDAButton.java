package com.ardakaplan.rdalibrary.ui.views.fontables;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by ardakaplan on 10/11/15.
 */
@SuppressWarnings("unused")
public class RDAButton extends android.support.v7.widget.AppCompatButton {
    public RDAButton(Context context) {
        super(context);
    }

    public RDAButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        Fonts.setFont(this, context, attrs, isInEditMode());
    }

    public RDAButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Fonts.setFont(this, context, attrs, isInEditMode());
    }
}
