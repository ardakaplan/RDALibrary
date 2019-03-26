package com.ardakaplan.rdalibrary.base.ui.views.custom;

import android.view.View;

/**
 * Created by Arda Kaplan on 18-Mar-19 - 10:05
 */
public abstract class RDAViewHolder {

    private View itemView;

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
        findViews(itemView);
    }

    public abstract void findViews(View itemView);
}
