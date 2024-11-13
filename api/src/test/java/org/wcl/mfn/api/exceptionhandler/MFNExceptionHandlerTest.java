package org.wcl.mfn.api.exceptionhandler;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import org.wcl.mfn.exceptions.validation.InvalidParameterException;

public class MFNExceptionHandlerTest {
    private MFNExceptionHandler testSubject;

    @BeforeEach
    public void setupTestSubject() {
        testSubject = new MFNExceptionHandler();
    }

    @Test
    public void whenInvalidParameterExceptionOccurs_thenResponseCorrectlyPopulated() {
        final var EXCEPTION_MESSAGE = "MFN-PARAM-001 : Exception message";

        final var result = testSubject.handleApiException(new InvalidParameterException(EXCEPTION_MESSAGE));
        assertThat(result).isNotNull();

        final var responseBody = result.getBody();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(responseBody).isNotNull();
        assertThat(responseBody).isEqualTo(EXCEPTION_MESSAGE);
    }
}
