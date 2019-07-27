package com.ardakaplan.rdalibrary.base.ui.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Arda Kaplan at 23-Jul-19
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDARecyclerViewHolder extends RecyclerView.ViewHolder {

    public RDARecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}
