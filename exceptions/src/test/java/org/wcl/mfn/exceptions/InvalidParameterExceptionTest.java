package org.wcl.mfn.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidParameterExceptionTest {
    @Test
    void givenExceptionOccurred_whenMessageConstructorUsed_thenMessageSetCorrectly() {
        assertEquals("Comms Fail",
                new InvalidParameterException("Comms Fail").getMessage(),
                "Exception message was not set");
    }

    @Test
    void givenExceptionOccurred_whenMessageAndErrorConstructorUsed_thenBothSetCorrectly() {
        final var dummyException = new Exception("Dummy");
        final var commsException = new InvalidParameterException("Comms Fail 2", dummyException);

        assertEquals("Comms Fail 2",
                commsException.getMessage(), "Exception message was not set");
        assertEquals(dummyException, commsException.getCause(), "Exception cause was not set");
    }
}
