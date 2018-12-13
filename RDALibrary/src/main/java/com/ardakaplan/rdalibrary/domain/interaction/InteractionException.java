package com.ardakaplan.rdalibrary.domain.interaction;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class InteractionException extends Exception{

    public InteractionException() {
        super();
    }


    public InteractionException(String message) {
        super(message);
    }


    public InteractionException(String message, Throwable cause) {
        super(message, cause);
    }


    public InteractionException(Throwable cause) {
        super(cause);
    }

}