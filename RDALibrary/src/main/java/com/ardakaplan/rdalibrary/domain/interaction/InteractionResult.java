package com.ardakaplan.rdalibrary.domain.interaction;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public class InteractionResult<Out> {

    private boolean success = false;
    private InteractionException exception;
    private Out out;

    public InteractionResult(Out out){
        this.success = true;
        this.out = out;
    }

    public InteractionResult(InteractionException exception){
        this.success = false;
        this.exception = exception;
    }

    public Out getOut(){
        return  out;
    }

    public boolean isSuccess() {
        return success;
    }

    public InteractionException getException(){
        return exception;
    }

    public static class Empty{

        public static Empty getValue(){
            return new Empty();
        }

    }
}