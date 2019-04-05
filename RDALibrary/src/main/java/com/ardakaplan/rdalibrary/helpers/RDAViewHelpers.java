package com.ardakaplan.rdalibrary.helpers;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Singleton;


@SuppressWarnings("unused")
@Singleton
public final class RDAViewHelpers {

    private Context context;

    @Inject
    RDAViewHelpers(Context context) {

        this.context = context;
    }

    public @ColorInt
    int getColorFromAttribute(@AttrRes int attribute) {

        TypedValue typedValue = new TypedValue();

        context.getTheme().resolveAttribute(attribute, typedValue, true);

        return typedValue.data;
    }

    public int getNumberInDp(int size) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, context.getResources().getDisplayMetrics());
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


}
