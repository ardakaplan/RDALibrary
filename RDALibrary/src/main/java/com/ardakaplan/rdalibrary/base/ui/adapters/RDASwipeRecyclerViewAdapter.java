package com.ardakaplan.rdalibrary.base.ui.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.List;

/**O
 * Created by Arda Kaplan on 20.06.2018 - 11:56
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class RDASwipeRecyclerViewAdapter<W, VH extends RecyclerView.ViewHolder> extends RecyclerSwipeAdapter<VH> {

    protected List<W> dataList;
    protected Activity activity;
    protected int layoutId;
    protected int swipelayoutId;

    public RDASwipeRecyclerViewAdapter(Activity activity, List<W> dataList, int layoutId, int swipelayoutId) {

        this.activity = activity;
        this.dataList = dataList;
        this.layoutId = layoutId;
        this.swipelayoutId = swipelayoutId;
    }

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

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return swipelayoutId;
    }
}
