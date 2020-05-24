package com.ardakaplan.rdalibrary.base.exceptions;

/**
 * Created by Arda Kaplan on 27-Feb-19 - 16:27
 */
public class RDAException extends Exception {

    public RDAException() {
        super();
    }

    public RDAException(String message) {
        super(message);
    }


    public RDAException(String message, Throwable cause) {
        super(message, cause);
    }


    public RDAException(Throwable cause) {
        super(cause);
    }
}
