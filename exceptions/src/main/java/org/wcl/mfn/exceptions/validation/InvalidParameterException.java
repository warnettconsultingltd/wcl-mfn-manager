package org.wcl.mfn.exceptions.validation;

public class InvalidParameterException extends Exception {
    public InvalidParameterException(final String message) {
        super(message);
    }

    public InvalidParameterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
