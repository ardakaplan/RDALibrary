package com.ardakaplan.rdalibrary.base.ui.views.rda_check_box;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ardakaplan.rdalibrary.R;


/**
 * Created by Arda Kaplan on 14/12/2017
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

@SuppressWarnings("unused")
public class RDACheckBox extends LinearLayout {

    private ImageView imageView;

    private int checkImageID;

    private boolean isChecked = false;

    public RDACheckBox(Context context) {
        super(context);

        inflateView(context);
    }

    public RDACheckBox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflateView(context);

        setCustomAttributes(context, attrs);
    }

    public RDACheckBox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflateView(context);

        setCustomAttributes(context, attrs);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {

        isChecked = checked;

        if (isChecked) {

            imageView.setImageResource(checkImageID);

        } else {

            imageView.setImageResource(android.R.color.transparent);
        }
    }

    private void inflateView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.layout_select_box, this, true);
    }

    public void setOnCheckListener(final OnCheckListener onCheckListener) {

        findViewById(R.id.layout_select_box_linearlayout_root).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                setChecked(!isChecked);

                onCheckListener.onClick(isChecked);
            }
        });
    }

    private void setCustomAttributes(Context context, @Nullable AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RDACheckBox);

        isChecked = typedArray.getBoolean(R.styleable.RDACheckBox_isChecked, false);

        TextView textView = findViewById(R.id.layout_select_box_textview);
        imageView = findViewById(R.id.layout_select_box_image_view);

        float gap = typedArray.getDimension(R.styleable.RDACheckBox_gap, 10);

        LayoutParams textViewLayoutParams = (LayoutParams) textView.getLayoutParams();
        textViewLayoutParams.leftMargin = (int) gap;
        textView.setLayoutParams(textViewLayoutParams);

        float checkBoxSize = typedArray.getDimension(R.styleable.RDACheckBox_checkBoxSize, 10);
        LayoutParams imageViewLayoutParams = (LayoutParams) imageView.getLayoutParams();
        imageViewLayoutParams.width = (int) checkBoxSize;
        imageViewLayoutParams.height = (int) checkBoxSize;
        imageView.setLayoutParams(imageViewLayoutParams);

        Drawable checkBoxFrame = typedArray.getDrawable(R.styleable.RDACheckBox_checkBoxFrame);

        imageView.setBackground(checkBoxFrame);

        checkImageID = typedArray.getResourceId(R.styleable.RDACheckBox_checkImage, android.R.color.transparent);

        if (isChecked) {

            imageView.setImageResource(checkImageID);
        }

        String text = typedArray.getString(R.styleable.RDACheckBox_text);
        textView.setText(text);

        float textSize = typedArray.getDimension(R.styleable.RDACheckBox_textSize, 15);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        int textColor = typedArray.getColor(R.styleable.RDACheckBox_textColor, Color.BLACK);
        textView.setTextColor(textColor);

        typedArray.recycle();
    }
}