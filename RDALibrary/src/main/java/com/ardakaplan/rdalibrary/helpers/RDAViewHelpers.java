package com.ardakaplan.rdalibrary.helpers;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import javax.inject.Inject;
import javax.inject.Singleton;


@SuppressWarnings({"unused", "JavaDoc"})
@Singleton
public final class RDAViewHelpers {

    private final Context context;

    @Inject
    RDAViewHelpers(Context context) {

        this.context = context;
    }

    public static void shrinkExtendToExtendedFloatingActionButtonByRecyclerViewScroll(RecyclerView recyclerView, ExtendedFloatingActionButton extendedFloatingActionButton) {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {

                    extendedFloatingActionButton.shrink();

                } else {

                    extendedFloatingActionButton.extend();
                }
            }
        });
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

    public static String getPureText(EditText editText) {

        return editText.getText().toString().trim();
    }

    public void setListenerForKeyboard(View activityRootView, KeyboardListener keyboardListener) {

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

    public static void changeSolidColorFromBackground(View view, @ColorInt int color) {

        GradientDrawable shape = (GradientDrawable) view.getBackground().mutate();

        shape.setColor(color);
    }

    public static void expand(final View v) {

        int matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getWidth(), View.MeasureSpec.EXACTLY);

        int wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec);

        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Expansion speed of 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // Collapse speed of 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public interface KeyboardListener {

        void onOpened();

        void onClosed();
    }

}
