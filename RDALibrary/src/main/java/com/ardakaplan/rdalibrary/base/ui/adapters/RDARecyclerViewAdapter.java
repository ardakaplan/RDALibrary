package com.ardakaplan.rdalibrary.base.ui.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardakaplan.rdalibrary.interfaces.RDAItemClickListener;

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

    protected RDAItemClickListener<ItemObject> rdaItemClickListener;

    protected List<ItemObject> dataList = new ArrayList<>();

    public RDARecyclerViewAdapter() {

    }

    public RDARecyclerViewAdapter(List<ItemObject> dataList) {
        this.dataList = dataList;
    }

    public void setRdaItemClickListener(RDAItemClickListener<ItemObject> rdaItemClickListener) {
        this.rdaItemClickListener = rdaItemClickListener;
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

//    @Override
//    public  VH onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View v = inflater.inflate(R.layout.row_layout, parent, false);
//
//        return new MyAdapter.ViewHolder(v);
//    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
