package com.ardakaplan.rdalibrary.base.ui.views;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
