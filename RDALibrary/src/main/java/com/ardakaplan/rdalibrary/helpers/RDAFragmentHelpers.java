package com.ardakaplan.rdalibrary.helpers;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAActivity;
import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAFragment;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.Random;

@SuppressWarnings("unused")
public final class RDAFragmentHelpers {

    //FragmentManager.OnBackStackChangedListener tetiklenince alınan fragment in id si
    private static int callingFragmentId = -1;

    private RDAFragmentHelpers() {

    }

    private static boolean isEqual(RDAFragment fragment1, RDAFragment fragment2) {

        return !(fragment1 == null || fragment2 == null) && fragment1.className.equals(fragment2.className);
    }

    public static void addFragmentToBackStack(RDAActivity activity, RDAFragment fragmentToReplace, int fragmentLayoutID, boolean clearBackStack) {

        fragmentToReplace.ID = new Random().nextInt(Integer.MAX_VALUE);

//        if (isEqual(getCurrentFragment(activity), fragmentToReplace)) {
////
////            return;
////        }

        if (clearBackStack) {

            activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

        activity.getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {

            @Override
            public void onBackStackChanged() {

                //bu method 2 kez çağrılıyor, bu yüzden id bazlı bir yönetim var, çağrılan id bir daha çağrılmıyor

                if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0) {

                    if (callingFragmentId == -1 || getCurrentFragment(activity).ID != callingFragmentId) {

                        callingFragmentId = getCurrentFragment(activity).ID;

                        getCurrentFragment(activity).onScreen();
                    }
                }
            }
        });

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

        transaction.addToBackStack(fragmentToReplace.className);

        transaction.commitAllowingStateLoss();
    }

    @SuppressWarnings("WeakerAccess")
    public static RDAFragment getCurrentFragment(RDAActivity activity) {

        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        if (fragmentManager.getFragments().size() > 0) {

            return (RDAFragment) fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 1);

        } else {

            return null;
        }
    }

    public static int getActiveFragmentCount(RDAActivity activity) {

        return activity.getSupportFragmentManager().getBackStackEntryCount();
    }
}