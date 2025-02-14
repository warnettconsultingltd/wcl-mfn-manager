package org.wcl.mfn.integration.tools.contractcalculator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.wcl.mfn.entities.contract.calculator.RequestedRemuneration;
import org.wcl.mfn.entities.contract.calculator.SuggestedContract;
import org.wcl.mfn.exceptions.InvalidParameterException;
import org.wcl.mfn.integration.utils.FileTestUtils;
import org.wcl.mfn.integration.utils.JsonTestUtils;
import org.wcl.mfn.integration.utils.JsonValidatingMatcher;
import org.wcl.mfn.integration.utils.URIFactory;
import org.wcl.mfn.service.tools.ContractCalculatorService;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@EnableAutoConfiguration
public class ContractCalculatorTest {
    private static final String VALID_JSON_FILE = "json/tools/contract-calculator/expected/expected-contract-calculator-valid.json";
    private static final String CONTRACT_CALCULATOR_ENDPOINT = "/api/contract-calculator";


    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = URIFactory.testURI(port, CONTRACT_CALCULATOR_ENDPOINT);
    }

    @MockBean
    private ContractCalculatorService contractCalculatorService;

    @Test
    public void givenValidRequestedRemuneration_whenRequestingSuggestedContracts_thenCalculatedSuggestedContractsReturned() {
        final var expectedResponseJson = FileTestUtils.testResourceFileAsJson(VALID_JSON_FILE);

        final var expectedData = JsonTestUtils.deserializeJsonAsList(expectedResponseJson, SuggestedContract.class).stream().toList();

        try {
            when(contractCalculatorService.suggestedContracts(695018, 72152864))
                .thenReturn(expectedData);
        } catch (InvalidParameterException e) {
            throw new RuntimeException(e);
        }

        RestAssured.with()
                .contentType(ContentType.JSON)
                .body(new RequestedRemuneration(695018, 72152864))
                .when()
                .request("POST", uri)
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .body("", JsonValidatingMatcher.matchFullJsonCollection(expectedResponseJson));
    }
}
