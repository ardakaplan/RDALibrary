package com.ardakaplan.rdalibrary.base.interactions;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDAInteraction<In, Out> {

    private In in;

    public RDAInteraction(In in) {
        this.in = in;
    }

    public RDAInteraction() {
        this.in = null;
    }

    public In getIn() {
        return in;
    }

    public void setIn(In in) {
        this.in = in;
    }

    public abstract void execute(RDAInteractionResultListener<Out> rdaInteractionResultListener);
}
