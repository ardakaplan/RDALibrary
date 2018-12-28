package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.interactions.exceptions.RDAInteractionException;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAPresenterContract;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAViewContract;

import java.util.ArrayList;

public class SplashContract {

    public interface SplashViewContract extends RDAViewContract {

        void testViewContract();

        void setList(ArrayList<String> list);

        void onError(RDAInteractionException e);

    }

    public interface SplashPresenterContract extends RDAPresenterContract<SplashViewContract> {

        void testPresenterContract();

        void getList();
    }
}
