package com.ardakaplan.rdalibrary.helpers;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;

import javax.inject.Inject;
import javax.inject.Singleton;


@SuppressWarnings({"unused", "JavaDoc"})
@Singleton
public final class RDAViewHelpers {

    private Context context;

    @Inject
    RDAViewHelpers(Context context) {

        this.context = context;
    }

    /**
     * does not work, be carefull before use
     *
     * @param attribute
     * @return
     */
    public @ColorInt
    int getColorFromAttribute(@AttrRes int attribute) {

        TypedValue typedValue = new TypedValue();

        context.getTheme().resolveAttribute(attribute, typedValue, true);

        return typedValue.data;
    }

    private void setListenerForKeyboard(View activityRootView, KeyboardListener keyboardListener) {

        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {

                int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();

                if (heightDiff > dpToPx(200)) {

                    keyboardListener.onOpened();

                } else {

                    keyboardListener.onClosed();
                }
            }
        });
    }

    public float dpToPx(int valueInDp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, context.getResources().getDisplayMetrics());
    }

    public void setTextSizeInSp(TextView textView, float size) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    /**
     * Cocuk sayisina gore listview uzunlugunu set eder,
     * <p>
     * kullanımı biraz sıkıntılı dikkatli ol
     */
    @Deprecated
    public void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        for (int i = 0; i < listView.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public interface KeyboardListener {

        void onOpened();

        void onClosed();
    }

}
