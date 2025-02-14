package org.wcl.mfn.comms.operations;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class BasicCommsOperationTest {
    private BasicCommsOperation<String> testOperation;

    @BeforeEach
    void setupTestOperation() {
        testOperation = new DummyBasicCommsOperation();
    }

    @Test
    void givenWebPageExists_whenPerformingAGet_thenTheConvertedWebPageDataIsReturned() {
        Assertions.assertEquals("Manage your own virtual professional football franchise.",testOperation.performGet("https://www.myfootballnow.com/"));
    }

    static class DummyBasicCommsOperation extends BasicCommsOperation<String> {

        DummyBasicCommsOperation() {
            super(new RestTemplate());
        }

        @Override
        protected String convert(String htmlText) {
            var returnText = "Not found";

            if (htmlText.contains("Manage your own virtual professional football franchise.")) {
                returnText = "Manage your own virtual professional football franchise.";
            }

            return returnText;
        }
    }
}
