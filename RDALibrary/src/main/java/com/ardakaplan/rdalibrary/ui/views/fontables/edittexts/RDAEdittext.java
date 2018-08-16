package com.ardakaplan.rdalibrary.ui.views.fontables.edittexts;

import android.content.Context;
import android.util.AttributeSet;

import com.ardakaplan.rdalibrary.ui.views.fontables.Fonts;


/**
 * Created by ardakaplan on 10/11/15.
 */
public class RDAEdittext extends android.support.v7.widget.AppCompatEditText {


    public RDAEdittext(Context context) {
        super(context);
    }

    public RDAEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);

        Fonts.setFont(this, context, attrs, isInEditMode());
    }

    public RDAEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Fonts.setFont(this, context, attrs, isInEditMode());
    }
}
