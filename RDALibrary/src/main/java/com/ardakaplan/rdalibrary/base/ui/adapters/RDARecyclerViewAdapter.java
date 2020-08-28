package com.ardakaplan.rdalibrary.base.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ardakaplan.rdalibrary.interfaces.RDAItemListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arda Kaplan
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

//    ItemObject for object
//    VH for view holder
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class RDARecyclerViewAdapter<ItemObject, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected RDAItemListener<ItemObject> rdaItemListener;

    protected List<ItemObject> dataList = new ArrayList<>();

    protected Integer selectedItemPosition;

    public RDARecyclerViewAdapter() {

    }

    public RDARecyclerViewAdapter(List<ItemObject> dataList) {

        this(dataList, null);
    }

    public RDARecyclerViewAdapter(RDAItemListener<ItemObject> rdaItemListener) {

        setRdaItemListener(rdaItemListener);
    }

    public RDARecyclerViewAdapter(List<ItemObject> dataList, RDAItemListener<ItemObject> rdaItemListener) {
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

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolderInstance(LayoutInflater.from(parent.getContext()).inflate(getItemLayout(), parent, false));
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

    public List<ItemObject> getDataList() {
        return dataList;
    }

    public @Nullable
    Integer getSelectedItemPosition() {
        return selectedItemPosition;
    }

    public void setSelectedItemPosition(Integer selectedItemPosition) {
        this.selectedItemPosition = selectedItemPosition;
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


    public ItemObject getItem(int position) {

        return dataList.get(position);
    }

    public void addItem(int position, ItemObject item) {

        dataList.add(position, item);

        notifyItemInserted(position);
    }

    public void removeItem(int position) {

        dataList.remove(position);

        notifyItemRemoved(position);
    }

    public void setData(List<ItemObject> dataList) {

        this.dataList = dataList;

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
