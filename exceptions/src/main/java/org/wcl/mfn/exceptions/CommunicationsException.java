package org.wcl.mfn.exceptions;

public class CommunicationsException extends Exception {
    public CommunicationsException(final String message) {
        super(message);
    }

    public CommunicationsException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
