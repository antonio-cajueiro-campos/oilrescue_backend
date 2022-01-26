package com.greenprojects.oilrescue.model.exception;

import org.springframework.security.core.AuthenticationException;

public class EmailAlreadyTakenException extends AuthenticationException {
    enum ex {
        EXCEPTION_POSTFIX_EMAIL_ALREADY_TAKEN,
        EXCEPTION_STRING_EMAIL_ALREADY_TAKEN,
        EXCEPTION_PREFIX_AUTHENTICATION
    }

    private void init(){
        ex error_code_postfix = ex.EXCEPTION_POSTFIX_EMAIL_ALREADY_TAKEN;
    }

    public EmailAlreadyTakenException(){
        super(ex.EXCEPTION_STRING_EMAIL_ALREADY_TAKEN.name());
        init();
    }

    public EmailAlreadyTakenException(String message){
        super(message.isEmpty() || message.isBlank() ? ex.EXCEPTION_STRING_EMAIL_ALREADY_TAKEN.name(): message);
        init();
    }

    public EmailAlreadyTakenException(String message, Throwable cause){
        super( message.isEmpty() || message.isBlank() ? ex.EXCEPTION_STRING_EMAIL_ALREADY_TAKEN.name(): message, cause);
        init();
    }

    public EmailAlreadyTakenException(Throwable cause){
        super(ex.EXCEPTION_STRING_EMAIL_ALREADY_TAKEN.name(), cause);
        init();
    }

    public static int getExpectedErrorCode(){
        return ex.EXCEPTION_PREFIX_AUTHENTICATION.compareTo(ex.EXCEPTION_POSTFIX_EMAIL_ALREADY_TAKEN);
    }

    public static boolean isErrorCodeAllowed(int errorCode){
        return errorCode == getExpectedErrorCode();
    }

}
