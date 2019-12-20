package com.ardakaplan.rdalibrary.base.ui.views.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

/**
 * Created by Arda Kaplan on 18-Mar-19 - 10:07
 */
public abstract class RDAView<VH extends RDAViewHolder> {

    private VH viewHolder;

    public RDAView(VH viewHolder){
        this.viewHolder = viewHolder;
    }

    public void onViewCreated(ViewGroup containerView){
        View viewForHolder = LayoutInflater.from(containerView.getContext()).inflate(getLayout(), containerView, true);
        viewHolder.setItemView(viewForHolder);

        onViewHolderCreated(viewHolder);
    }

    public Context getContext() {
        return viewHolder.getItemView().getContext();
    }

    @LayoutRes
    protected abstract int getLayout();

    public void onViewDestroyed(){

    }

    public void onPause(){

    }

    public void onResume(){

    }

    public VH getViewHolder(){
        return viewHolder;
    }

    public abstract void onViewHolderCreated(VH viewHolder);
}