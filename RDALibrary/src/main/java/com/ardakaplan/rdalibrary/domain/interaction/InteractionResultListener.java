package com.ardakaplan.rdalibrary.domain.interaction;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public interface InteractionResultListener<Out> {

    void onResult(InteractionResult<Out> out);

}
