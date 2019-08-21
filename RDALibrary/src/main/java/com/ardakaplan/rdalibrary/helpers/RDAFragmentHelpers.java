package com.ardakaplan.rdalibrary.helpers;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAActivity;
import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAFragment;

@SuppressWarnings("unused")
public final class RDAFragmentHelpers {

    private RDAFragmentHelpers() {

    }

    private static boolean isEqual(RDAFragment fragment1, RDAFragment fragment2) {

        return !(fragment1 == null || fragment2 == null) && fragment1.className.equals(fragment2.className);
    }

    public static void addFragmentToBackStack(RDAActivity activity, RDAFragment fragmentToReplace, int fragmentLayoutID, boolean clearBackStack) {

        if (isEqual(getCurrentFragment(activity), fragmentToReplace)) {

            return;
        }

        if (clearBackStack) {

            activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

        if (fragmentToReplace.getFragmentAnimationList().length == 4) {

            transaction.setCustomAnimations(fragmentToReplace.getFragmentAnimationList()[0],
                                            fragmentToReplace.getFragmentAnimationList()[1],
                                            fragmentToReplace.getFragmentAnimationList()[2],
                                            fragmentToReplace.getFragmentAnimationList()[3]);
        }

        transaction.replace(fragmentLayoutID, fragmentToReplace);

        transaction.addToBackStack(fragmentToReplace.className);

        transaction.commitAllowingStateLoss();
    }

    @SuppressWarnings("WeakerAccess")
    public static RDAFragment getCurrentFragment(RDAActivity activity) {

        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        if (fragmentManager.getFragments() != null && fragmentManager.getFragments().size() > 0) {

            return (RDAFragment) fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 1);

        } else {

            return null;
        }
    }

    public static int getActiveFragmentCount(RDAActivity activity) {

        return activity.getSupportFragmentManager().getBackStackEntryCount();
    }
}