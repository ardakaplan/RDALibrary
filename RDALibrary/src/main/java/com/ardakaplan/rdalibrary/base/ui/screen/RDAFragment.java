package com.ardakaplan.rdalibrary.base.ui.screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ardakaplan.rdalibrary.helpers.RDAFragmentHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.Serializable;

@SuppressWarnings("unused")
@Deprecated
public abstract class RDAFragment extends Fragment {

    public String className;

    public RDAFragment() {
        className = getClass().getSimpleName();
    }


    protected RDAFragmentActivity getContainerActivity() {

        return (RDAFragmentActivity) getActivity();
    }

    public int[] getFragmentAnimationList() {

        return new int[]{};
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RDALogger.logLifeCycle(className);

        return inflater.inflate(setLayout(), container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onStart() {
        super.onStart();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onResume() {
        super.onResume();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onPause() {
        super.onPause();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onStop() {
        super.onStop();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        RDALogger.logLifeCycle(className);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        RDALogger.logLifeCycle(className);
    }

    public Serializable getFragmentData(String key) {

        if (getArguments() != null && getArguments().containsKey(key)) {

            return getArguments().getSerializable(key);

        } else {

            return null;
        }
    }


    public boolean checkFragmentData(String key) {

        return this.getArguments() != null && this.getArguments().containsKey(key);
    }


    public void open(RDAFragmentActivity rdaActivity, String key, Serializable fragmentData, boolean clearBackStack) {

        Bundle bundle = new Bundle();

        bundle.putSerializable(key, fragmentData);

        open(rdaActivity, bundle, clearBackStack);
    }

    public void open(RDAFragmentActivity rdaActivity, String key, Serializable fragmentData) {

        Bundle bundle = new Bundle();

        bundle.putSerializable(key, fragmentData);

        open(rdaActivity, bundle, false);
    }

    public void open(RDAFragmentActivity rdaActivity, boolean clearBackStack) {

        open(rdaActivity, null, clearBackStack);
    }

    public void open(RDAFragmentActivity rdaActivity) {

        open(rdaActivity, false);
    }


    public void open(RDAFragmentActivity rdaActivity, Bundle fragmentDataBundle, boolean clearBackStack) {

        if (fragmentDataBundle != null) {

            this.setArguments(fragmentDataBundle);
        }

        RDAFragmentHelpers.addFragmentToBackStack(rdaActivity, this, fragmentLayoutID(), clearBackStack);
    }

    public void open(RDAFragmentActivity rdaActivity, Bundle fragmentDataBundle) {

        open(rdaActivity, fragmentDataBundle, false);
    }


    public abstract int fragmentLayoutID();

    protected abstract int setLayout();
}