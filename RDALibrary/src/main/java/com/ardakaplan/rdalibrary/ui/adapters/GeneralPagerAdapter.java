package com.ardakaplan.rdalibrary.ui.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ardakaplan on 06/01/16.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class GeneralPagerAdapter<W> extends PagerAdapter {

    protected Activity activity;
    protected LayoutInflater inflater;
    protected List<W> arrayList;
    protected Integer layoutID;

    public GeneralPagerAdapter(Activity activity, List<W> arrayList, Integer layoutID) {
        this.activity = activity;
        this.arrayList = arrayList;
        this.layoutID = layoutID;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    protected W getItem(int position) {

        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View viewLayout = inflater.inflate(layoutID, container, false);

        container.addView(viewLayout);

        return viewLayout;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
