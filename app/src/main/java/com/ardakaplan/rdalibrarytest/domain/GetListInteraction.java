package com.ardakaplan.rdalibrarytest.domain;

import com.ardakaplan.rdalibrary.domain.interaction.Interaction;
import com.ardakaplan.rdalibrary.domain.interaction.InteractionResult;
import com.ardakaplan.rdalibrary.domain.interaction.InteractionResultListener;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public class GetListInteraction extends Interaction<String, ArrayList<String>> {


    @Inject
    GetListInteraction() {

    }

    @Override
    public void execute(InteractionResultListener<ArrayList<String>> interactionResultListener) {

        boolean testException = false;

        if (testException) {

            interactionResultListener.onResult(new InteractionResult(new GetListException()));
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            list.add(getIn() + " " + i);
        }

        interactionResultListener.onResult(new InteractionResult<>(list));

    }
}
