package com.ardakaplan.rdalibrary.ui.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ardakaplan on 18/11/15.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class RDASpinnerAdapter<W> extends RDABaseAdapter<W> {


    protected Integer spinnerViewLayoutId;
    protected Integer dropdownViewLayoutId;

    public RDASpinnerAdapter(Activity activity, List<W> list, Integer spinnerViewLayoutId, Integer dropdownViewLayoutId) {
        super(activity, list);
        this.spinnerViewLayoutId = spinnerViewLayoutId;
        this.dropdownViewLayoutId = dropdownViewLayoutId;
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View spinnerView, ViewGroup parent) {
        return layoutInflater.inflate(spinnerViewLayoutId, parent, false);
    }

    @Override
    public View getDropDownView(int position, View dropdownItem, ViewGroup parent) {
        return layoutInflater.inflate(dropdownViewLayoutId, parent, false);
    }

}
