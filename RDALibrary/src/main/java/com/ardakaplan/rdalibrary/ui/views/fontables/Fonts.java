package com.ardakaplan.rdalibrary.ui.views.fontables;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ardakaplan.rdalibrary.R;


/**
 * Created by ardakaplan on 09/12/15.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
public class Fonts {

//    private static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";
//    private static final String TEXT_STYLE = "textStyle";

    public static void setFont(TextView textView, Context context, AttributeSet attrs, boolean isInEditMode) {

        if (!isInEditMode) {

            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Custom_Font);

            if (typedArray.hasValue(R.styleable.Custom_Font_fonty)) {

                //if icine yazdigim icin artik default deger 1 in bir onemi yok
                int type = typedArray.getInt(R.styleable.Custom_Font_fonty, 1);

                // attrs enumlarinin sirasi 1 den basladigi icin "-1" islemi
                Typeface typeface = Typeface.createFromAsset(context.getAssets(), Font.values()[type - 1].getPath());

                textView.setTypeface(typeface);
            }

            typedArray.recycle();
        }
    }

    public enum Font {
        LEIGH_BLACK("fonts/lehigh_personal_black.otf"),
        LEIGH_BOLD("fonts/lehigh_personal_bold.otf"),
        LEIGH_LIGHT("fonts/lehigh_personal_light.otf"),
        LEIGH_REGULAR("fonts/lehigh_personal_regular.otf"),
        LEIGH_SEMI_BOLD("fonts/lehigh_personal_semi_bold.otf"),
        LEIGH_THIN("fonts/lehigh_personal_thin.otf"),
        CHOCOCOOKY("fonts/chococooky.ttf"),
        AMATIC("fonts/amatic.ttf"),
        AMATIC_BOLD("fonts/amatic_bold.ttf"),
        ALPHA("fonts/alpha.ttf"),
        BEBAS_BOLD("fonts/bebas_neue_bold.otf");

        private String path;

        Font(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}