package org.wcl.mfn.api.exceptionhandler;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.wcl.mfn.exceptions.validation.InvalidParameterException;

public class MFNExceptionHandlerTest {
    private MFNExceptionHandler testSubject;

    @BeforeEach
    public void setupTestSubject() {
        testSubject = new MFNExceptionHandler();
    }

    @Test
    public void whenInvalidParameterExceptionOccurs_thenResponseCorrectlyPopulated() {
        final var EXCEPTION_ID = "MFN-PARAM-001";
        final var EXCEPTION_MESSAGE = "Exception message";

        final var result = testSubject.handleApiException(EXCEPTION_ID,
                                                          new InvalidParameterException(EXCEPTION_MESSAGE));
        assertThat(result).isNotNull();

        final var responseBody = result.getBody();
        assertThat(responseBody).isNotNull();
        assertThat(responseBody.id()).isEqualTo(EXCEPTION_ID);
        assertThat(responseBody.message()).isEqualTo(EXCEPTION_MESSAGE);
    }
}
