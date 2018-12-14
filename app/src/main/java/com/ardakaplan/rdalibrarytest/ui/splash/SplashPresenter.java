package com.ardakaplan.rdalibrarytest.ui.splash;

import com.ardakaplan.rdalibrary.domain.interaction.InteractionResult;
import com.ardakaplan.rdalibrary.domain.interaction.InteractionResultListener;
import com.ardakaplan.rdalibrary.base.objects.RDAPresenter;
import com.ardakaplan.rdalibrarytest.domain.GetListInteraction;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.ArrayList;

import javax.inject.Inject;

public class SplashPresenter extends RDAPresenter<SplashContract.SplashViewContract> implements SplashContract.SplashPresenterContract {

    private GetListInteraction getListInteraction;

    @Inject
    public SplashPresenter(GetListInteraction getListInteraction) {

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

        getListInteraction.execute(new InteractionResultListener<ArrayList<String>>() {

            @Override
            public void onResult(InteractionResult<ArrayList<String>> out) {

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
