package com.ardakaplan.rdalibrary.base.objects;

import android.os.Bundle;

/**
 * Created by Arda Kaplan at 12/20/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public class RDATabHostFragment extends RDAObject {

    private String tabTitle;
    private Class fragmentClass;
    private String tag;
    private Bundle bundle;

    public RDATabHostFragment(String tabTitle, Class fragmentClass, String tag, Bundle bundle) {
        this.tabTitle = tabTitle;
        this.fragmentClass = fragmentClass;
        this.tag = tag;
        this.bundle = bundle;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public Class getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
