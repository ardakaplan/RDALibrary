package com.ardakaplan.rdalibrary.base.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ardakaplan.rdalibrary.interfaces.RDAItemListener;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * O
 * Created by Arda Kaplan on 20.06.2018 - 11:56
 */
@SuppressWarnings({"WeakerAccess", "unused"})

public abstract class RDASwipeRecyclerViewAdapter<ItemObject, VH extends RecyclerView.ViewHolder> extends RecyclerSwipeAdapter<VH> {

    protected RDAItemListener<ItemObject> rdaItemListener;

    protected List<ItemObject> dataList = new ArrayList<>();

    protected Integer selectedItemPosition;

    public RDASwipeRecyclerViewAdapter() {

    }

    public RDASwipeRecyclerViewAdapter(List<ItemObject> dataList) {

        this(dataList, null);
    }

    public RDASwipeRecyclerViewAdapter(RDAItemListener<ItemObject> rdaItemListener) {

        setRdaItemListener(rdaItemListener);
    }

    public RDASwipeRecyclerViewAdapter(List<ItemObject> dataList, RDAItemListener<ItemObject> rdaItemListener) {
        this.dataList = dataList;

        setRdaItemListener(rdaItemListener);
    }

    public void setRdaItemListener(RDAItemListener<ItemObject> rdaItemListener) {
        this.rdaItemListener = rdaItemListener;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        setItemClick(holder, position);
    }

    protected void setItemClick(VH vh, int position) {

        vh.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (rdaItemListener != null) {

                    rdaItemListener.onItemClick(getItem(position), position);

                    selectedItemPosition = position;

                    itemClicked(vh, position);
                }
            }
        });
    }

    protected void itemClicked(VH vh, int position) {

    }

    public void removeItem(int position) {

        dataList.remove(position);

        notifyItemRemoved(position);

        notifyItemRangeChanged(position, getItemCount());
    }

    public void addItem(int position, ItemObject itemObject) {

        dataList.add(position, itemObject);

        notifyItemInserted(position);

        notifyItemRangeChanged(position, getItemCount());
    }

    public void changeItem(int position, ItemObject itemObject) {

        dataList.set(position, itemObject);

        notifyItemChanged(position);
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

    public void setData(List<ItemObject> dataList) {

        this.dataList = dataList;

        notifyDataSetChanged();
    }

    protected ItemObject getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
