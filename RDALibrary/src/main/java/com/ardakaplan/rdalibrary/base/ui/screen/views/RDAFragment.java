package com.ardakaplan.rdalibrary.base.ui.screen.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;

import com.ardakaplan.rdalibrary.base.ui.screen.ViewController;
import com.ardakaplan.rdalibrary.base.ui.screen.screencontracts.ScreenContract;
import com.ardakaplan.rdalibrary.helpers.RDADeviceHelpers;
import com.ardakaplan.rdalibrary.helpers.RDAStringHelpers;
import com.ardakaplan.rdalibrary.helpers.RDAViewHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

@SuppressWarnings("unused")
public abstract class RDAFragment extends DaggerFragment implements ScreenContract, RDAViewContract, ViewController {

    public String className;

    private Unbinder unbinder;

    public RDAFragment() {
        className = getClass().getSimpleName();
    }

    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    @Override
    public void closeKeyboard() {

        RDADeviceHelpers.closeKeyboard(getContainerActivity());
    }

    @Override
    public boolean isEditTextFilled(EditText editText) {
        return RDAStringHelpers.isFilled(this.getPureText(editText));
    }

    @Override
    public boolean isEditTextEmpty(EditText editText) {
        return RDAStringHelpers.isEmpty(getPureText(editText));
    }

    @Override
    public String getPureText(EditText editText) {
        return RDAViewHelpers.getPureText(editText);
    }

    protected void activityOnBackPressed() {

        if (getContainerActivity() != null) {

            getContainerActivity().onBackPressed();
        }
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

        View view = inflater.inflate(getLayoutId(), container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }


    public RDAActivity getContainerActivity() {

        return ((RDAActivity) getActivity());
    }

    @Override
    public void changeStatusBarColor(@ColorRes int colorId) {

        if (getContainerActivity() != null) {

            getContainerActivity().changeStatusBarColor(colorId);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getPresenterContract() != null) {

            //noinspection unchecked
            getPresenterContract().attach(this);
        }

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

        unbinder.unbind();

        if (getPresenterContract() != null) {

            getPresenterContract().detach();
        }

        RDALogger.logLifeCycle(className);
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
}