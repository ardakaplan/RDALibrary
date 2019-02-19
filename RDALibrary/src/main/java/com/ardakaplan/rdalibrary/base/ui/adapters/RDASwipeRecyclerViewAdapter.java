package com.ardakaplan.rdalibrary.base.ui.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * O
 * Created by Arda Kaplan on 20.06.2018 - 11:56
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class RDASwipeRecyclerViewAdapter<W, VH extends RecyclerView.ViewHolder> extends RecyclerSwipeAdapter<VH> {

    protected List<W> dataList;

    public RDASwipeRecyclerViewAdapter(List<W> dataList) {
        this.dataList = dataList;
    }

    public RDASwipeRecyclerViewAdapter() {
        dataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolderInstance(LayoutInflater.from(parent.getContext()).inflate(getItemLayout(), parent, false));
    }

    /**
     * @param view inflated view
     * @return object that used in every row view
     */
    protected abstract VH getViewHolderInstance(View view);

    /**
     * @return item layout
     */
    protected abstract @LayoutRes
    int getItemLayout();

    public void setData(List<W> dataList) {

        this.dataList = dataList;

        notifyDataSetChanged();
    }

    protected W getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
