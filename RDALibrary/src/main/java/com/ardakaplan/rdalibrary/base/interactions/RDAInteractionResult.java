package com.ardakaplan.rdalibrary.base.interactions;

import com.ardakaplan.rdalibrary.base.exceptions.RDAInteractionException;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public class RDAInteractionResult<Out> {

    private boolean success = false;
    private Exception exception;
    private Out out;

    public RDAInteractionResult(Out out){
        this.success = true;
        this.out = out;
    }

    public RDAInteractionResult(Exception exception){
        this.success = false;
        this.exception = exception;
    }

    public Out getOut(){
        return  out;
    }

    public boolean isSuccess() {
        return success;
    }

    public Exception getException(){
        return exception;
    }

    public static class Empty{

        public static Empty getValue(){
            return new Empty();
        }

    }
}