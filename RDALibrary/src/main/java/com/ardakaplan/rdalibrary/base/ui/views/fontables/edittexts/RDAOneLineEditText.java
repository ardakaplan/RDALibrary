package com.ardakaplan.rdalibrary.base.ui.views.fontables.edittexts;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

/**
 * Created by ardakaplan on 08/12/15.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
public class RDAOneLineEditText extends AppCompatEditText {

    TextWatcher onlyOneLineTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            for (int i = s.length(); i > 0; i--) {
                if (s.subSequence(i - 1, i).toString().equals("\n"))
                    s.replace(i - 1, i, "");
            }
        }
    };

    public RDAOneLineEditText(Context context) {
        super(context);

        setMaxLines(1);

        this.addTextChangedListener(onlyOneLineTextWatcher);
    }

    public RDAOneLineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        setMaxLines(1);

        this.addTextChangedListener(onlyOneLineTextWatcher);
    }

    public RDAOneLineEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setMaxLines(1);

        this.addTextChangedListener(onlyOneLineTextWatcher);
    }
}
