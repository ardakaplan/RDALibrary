package com.ardakaplan.rdalibrary.base.ui.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Genel list adapter
 *
 * @param <W>
 * @author Arda
 */
public abstract class RDAListAdapter<W> extends RDABaseAdapter<W> {

    protected Integer rowLayoutId;

    public RDAListAdapter(Activity activity, List<W> list, Integer rowLayoutId) {
        super(activity, list);
        this.rowLayoutId = rowLayoutId;
    }

    @Override
    public final View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View row, ViewGroup parent) {

        return layoutInflater.inflate(rowLayoutId, parent, false);
    }
}
