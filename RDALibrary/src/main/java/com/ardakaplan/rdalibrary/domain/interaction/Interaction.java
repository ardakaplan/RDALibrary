package com.ardakaplan.rdalibrary.domain.interaction;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class Interaction<In, Out> {

    private In in;

    public Interaction(In in) {
        this.in = in;
    }

    public Interaction() {
        this.in = null;
    }

    public In getIn() {
        return in;
    }

    public void setIn(In in) {
        this.in = in;
    }

    public abstract void execute(InteractionResultListener<Out> interactionResultListener);
}
