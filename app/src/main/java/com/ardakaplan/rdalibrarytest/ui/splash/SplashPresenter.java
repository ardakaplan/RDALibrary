package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResult;
import com.ardakaplan.rdalibrary.base.interactions.RDAInteractionResultListener;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAPresenter;
import com.ardakaplan.rdalibrarytest.domain.GetListRDAInteraction;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.ArrayList;

import javax.inject.Inject;

public class SplashPresenter extends RDAPresenter<SplashContract.SplashViewContract> implements SplashContract.SplashPresenterContract {

    private GetListRDAInteraction getListInteraction;

    @Inject
    public SplashPresenter(GetListRDAInteraction getListInteraction) {

        this.getListInteraction = getListInteraction;
    }

    @Override
    protected void onAttached() {

    }

    @Override
    protected void onDetached() {

    }

    @Override
    public void testPresenterContract() {

        RDALogger.info("SPLASH PRESENTER ÇALIŞTI");
    }

    @Override
    public void getList() {

        getListInteraction.setIn("LAHANA");

        getListInteraction.execute(new RDAInteractionResultListener<ArrayList<String>>() {

            @Override
            public void onResult(RDAInteractionResult<ArrayList<String>> out) {

                if (gettView() != null) {

                    if (out.isSuccess()) {

                        gettView().setList(out.getOut());

                    } else {

                        gettView().onError(out.getException());
                    }
                }
            }
        });
    }
}
