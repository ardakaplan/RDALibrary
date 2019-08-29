package com.ardakaplan.rdalibrary.base.exceptions;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDAInteractionException extends Exception {

//    private int code;
//
//    public RDAInteractionException(int code) {
//        super();
//        this.code = code;
//    }

    public RDAInteractionException() {
        super();
    }

    public RDAInteractionException(String message) {
        super(message);
    }


    public RDAInteractionException(String message, Throwable cause) {
        super(message, cause);
    }


    public RDAInteractionException(Throwable cause) {
        super(cause);
    }

//    public int getCode() {
//        return code;
//    }
}