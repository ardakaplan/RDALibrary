package com.ardakaplan.rdalibrary.base.interactions;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public interface RDAInteractionResultListener<Out> {

    void onResult(RDAInteractionResult<Out> rdaInteractionResult);

}
