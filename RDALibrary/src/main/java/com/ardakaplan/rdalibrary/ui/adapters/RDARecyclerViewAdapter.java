package com.ardakaplan.rdalibrary.ui.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arda Kaplan
 * <p>
 * arda.kaplan09@gmail.com
 * <p>
 * www.ardakaplan.com
 */

//    D for object
//    VH for view holder
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class RDARecyclerViewAdapter<D, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<D> dataList = new ArrayList<>();

    public RDARecyclerViewAdapter() {

    }

    public RDARecyclerViewAdapter(List<D> dataList) {
        this.dataList = dataList;
    }

    public D getItem(int position) {

        return dataList.get(position);
    }

    public void addItem(int position, D item) {

        dataList.add(position, item);

        notifyItemInserted(position);
    }

    public void removeItem(int position) {

        dataList.remove(position);

        notifyItemRemoved(position);
    }

    public void setData(List<D> dataList) {

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
