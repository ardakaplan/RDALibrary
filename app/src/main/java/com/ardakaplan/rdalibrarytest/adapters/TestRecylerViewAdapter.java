package com.ardakaplan.rdalibrarytest.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ardakaplan.rdalibrary.ui.adapters.RDARecyclerViewAdapter;
import com.ardakaplan.rdalibrarytest.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Arda Kaplan on 19.09.2018 - 15:30
 */
public class TestRecylerViewAdapter extends RDARecyclerViewAdapter<String, TestRecylerViewAdapter.TestRecyclerViewHolder> {


    public TestRecylerViewAdapter(ArrayList<String> list) {
        super(list);
    }


    @Override
    public void onBindViewHolder(@NonNull TestRecyclerViewHolder holder, int position) {

        holder.itemTextView.setText(getItem(position));
    }

    @Override
    protected TestRecyclerViewHolder getViewHolderInstance(View view) {
        return new TestRecyclerViewHolder(view);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_recyclerview;
    }

    public class TestRecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_recyclerview_textview)
        TextView itemTextView;

        TestRecyclerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
