package com.ardakaplan.rdalibrary.base.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Created by ardakaplan on 06/01/16.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class RDAPagerAdapter<W> extends PagerAdapter {

    protected Context context;
    protected LayoutInflater inflater;
    protected List<W> arrayList;
    protected Integer layoutID;

    public RDAPagerAdapter(Context context, List<W> arrayList, Integer layoutID) {
        this.context = context;
        this.arrayList = arrayList;
        this.layoutID = layoutID;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
