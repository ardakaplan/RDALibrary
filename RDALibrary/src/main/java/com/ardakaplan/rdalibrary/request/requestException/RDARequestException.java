package com.ardakaplan.rdalibrary.request.requestException;

/**
 * Created by Arda Kaplan on 28-Dec-18 - 15:08
 */
public abstract class RDARequestException extends Exception {

    public RDARequestException() {
        super();
    }


    public RDARequestException(String message) {
        super(message);
    }


    public RDARequestException(String message, Throwable cause) {
        super(message, cause);
    }


    public RDARequestException(Throwable cause) {
        super(cause);
    }
}
