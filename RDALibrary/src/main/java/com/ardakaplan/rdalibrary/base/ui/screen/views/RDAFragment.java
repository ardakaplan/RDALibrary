package com.ardakaplan.rdalibrary.base.ui.screen.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

import com.ardakaplan.rdalibrary.base.ui.screen.screencontracts.ScreenContract;
import com.ardakaplan.rdalibrary.helpers.RDAFragmentHelpers;
import com.ardakaplan.rdalogger.RDALogger;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

@SuppressWarnings("unused")
public abstract class RDAFragment extends DaggerFragment implements ScreenContract, RDAViewContract {

    //FragmentManager.OnBackStackChangedListener yönetimi için oluşturulan id, manager dışında kesinlikle kullanılmaması lazım
    public int ID = 0;

    protected String rdaTag = this.getClass().getSimpleName();

    public String className;

    private Unbinder unbinder;

    public String getRdaTag() {
        return rdaTag;
    }

    public RDAFragment() {
        className = getClass().getSimpleName();
    }

    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);

        super.onAttach(context);
    }

    public void onScreen() {

    }

    protected void closeKeyboard() {

        if (getContainerActivity() != null) {

            getContainerActivity().closeKeyboard();
        }
    }

    public String getPureText(EditText editText) {

        return editText.getText().toString().trim();
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

        View view = inflater.inflate(getLayout(), container, false);

        unbinder = ButterKnife.bind(this, view);

        initViews(view);

        return view;
    }

    protected void initViews(View parentView) {

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

    public void open(RDAActivity rdaActivity) {

        open(rdaActivity, false);
    }

    public void open(RDAActivity rdaActivity, boolean clearBackStack) {

        if (rdaActivity != null) {

            getFragmentHelpers().addFragmentToBackStack(rdaActivity, this, fragmentPartContainerId(), clearBackStack);
        }
    }

    public abstract RDAFragmentHelpers getFragmentHelpers();

    public abstract @IdRes
    int fragmentPartContainerId();
}