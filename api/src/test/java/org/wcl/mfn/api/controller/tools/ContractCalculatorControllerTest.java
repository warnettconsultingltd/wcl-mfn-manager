package org.wcl.mfn.api.controller.tools;

import io.restassured.http.ContentType;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.wcl.mfn.api.testutils.*;
import org.wcl.mfn.entities.contract.calculator.*;
import org.wcl.mfn.service.tools.ContractCalculatorService;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.with;

@SpringBootTest(classes= {ContractCalculatorController.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@EnableAutoConfiguration
public class ContractCalculatorControllerTest {

    private static final String VALID_JSON_FILE = "json/tools/contract-calculator-valid.json";

    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = URIFactory.testURI(port,"/contract-calculator");
    }

    @MockBean
    ContractCalculatorService contractCalculatorService;

    @Test
    public void  givenValidRequestedRemuneration_whenRequestingSuggestedContracts_thenCalculatedSuggestedContractsReturned() throws IOException {
        final var expectedResponseJson = FileTestUtils.testResourceFileAsJson(VALID_JSON_FILE);

        final var expectedData =(List<SuggestedContract>) JsonTestUtils.deserializeJson(expectedResponseJson,
                SuggestedContract.class);

        Mockito.when(contractCalculatorService.suggestedContracts(695018,72152864))
                .thenReturn(expectedData);

        with()
                .contentType(ContentType.JSON)
                .body(new RequestedRemuneration(695018, 72152864))
            .when()
                .request("POST",  uri)
            .then()
                .statusCode(HttpStatus.OK.value())
            .and()
                .body("", JsonValidatingMatcher.matchFullJsonCollection(expectedResponseJson));
    }
}
