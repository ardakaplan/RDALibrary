package com.ardakaplan.rdalibrary.ui.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ardakaplan on 19/11/15.
 */
@SuppressWarnings("WeakerAccess")
public abstract class GeneralBaseAdapter<W> extends BaseAdapter {


    protected Activity activity;
    protected List<W> list;
    protected LayoutInflater layoutInflater;

    public GeneralBaseAdapter(Activity activity, List<W> list) {
        this.activity = activity;
        this.list = list;
        layoutInflater = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public W getItem(int position) {
        if (list == null) {
            return null;
        }
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


}
