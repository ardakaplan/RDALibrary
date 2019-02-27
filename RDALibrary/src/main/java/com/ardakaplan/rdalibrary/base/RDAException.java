package com.ardakaplan.rdalibrary.base;

/**
 * Created by Arda Kaplan on 27-Feb-19 - 16:27
 */
public class RDAException extends Exception {

    private int code;

    public RDAException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
