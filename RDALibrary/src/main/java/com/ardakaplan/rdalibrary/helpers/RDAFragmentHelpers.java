package com.ardakaplan.rdalibrary.helpers;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAActivity;
import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAInnerFragment;

import java.util.Random;

@SuppressWarnings("unused")
public class RDAFragmentHelpers {

    //FragmentManager.OnBackStackChangedListener tetiklenince alınan fragment in id si
    protected static int callingFragmentId = -1;

    protected boolean isEqual(RDAInnerFragment fragment1, RDAInnerFragment fragment2) {

        return !(fragment1 == null || fragment2 == null) && fragment1.className.equals(fragment2.className);
    }

    public void addFragmentToBackStack(RDAActivity activity, RDAInnerFragment fragmentToReplace, int fragmentLayoutID, boolean clearBackStack) {

        fragmentToReplace.ID = new Random().nextInt(Integer.MAX_VALUE);

//        if (isEqual(getCurrentFragment(activity), fragmentToReplace)) {
////
////            return;
////        }

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


        if (activity.getSupportFragmentManager().findFragmentById(fragmentLayoutID) == null) {

            transaction.add(fragmentLayoutID, fragmentToReplace);

        } else {

            transaction.hide(activity.getSupportFragmentManager().findFragmentById(fragmentLayoutID));

            transaction.add(fragmentLayoutID, fragmentToReplace);
        }

//        transaction.add(fragmentToReplace)

        transaction.addToBackStack(fragmentToReplace.getRdaTag());

        transaction.commitAllowingStateLoss();
    }

    @SuppressWarnings("WeakerAccess")
    public RDAInnerFragment getCurrentFragment(RDAActivity activity) {

        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        if (fragmentManager.getFragments().size() > 0) {

            return (RDAInnerFragment) fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 1);

        } else {

            return null;
        }
    }

    public int getActiveFragmentCount(RDAActivity activity) {

        return activity.getSupportFragmentManager().getBackStackEntryCount();
    }
}