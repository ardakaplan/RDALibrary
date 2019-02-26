package com.ardakaplan.rdalibrary;

/**
 * Created by Arda Kaplan on 28-Dec-18 - 15:08
 */
public class RDARequestException extends Exception {

    private HttpErrorType httpError;
    private String message;

    public RDARequestException(HttpErrorType httpError, Throwable cause) {
        super(cause);

        this.message = cause.getMessage();

        this.httpError = httpError;
    }

    public RDARequestException(HttpErrorType httpError, String message) {

        this.message = message;

        this.httpError = httpError;
    }


    public RDARequestException(HttpErrorType httpError) {

        this.httpError = httpError;
    }


    @Override
    public synchronized Throwable getCause() throws NullPointerException {
        return super.getCause();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpErrorType getHttpError() {
        return httpError;
    }

    public enum HttpErrorType {

        AUTHENTICATION_ERROR(401),
        NOT_FOUND_ERROR(404),
        SERVER_ERROR(500),
        UNKNOWN_ERROR(-1),
        NULL_RESPONSE_ERROR(-2),
        NO_NETWORK_ERROR(-3),
        SHOW_SERVER_MESSAGE_ERROR(-4);

        private int httpErrorCode;

        HttpErrorType(int httpErrorCode) {
            this.httpErrorCode = httpErrorCode;
        }

        public int getHttpErrorCode() {
            return httpErrorCode;
        }
    }
}
