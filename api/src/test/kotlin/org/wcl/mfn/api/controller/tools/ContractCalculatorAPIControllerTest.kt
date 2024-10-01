package org.wcl.mfn.api.controller.tools

import io.restassured.RestAssured
import io.restassured.http.ContentType
import jakarta.annotation.PostConstruct
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.wcl.mfn.api.testutils.*
import org.wcl.mfn.entities.contract.calculator.*
import org.wcl.mfn.service.tools.ContractCalculatorService
import java.io.IOException

@SpringBootTest(
    classes = [ContractCalculatorAPIController::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@EnableConfigurationProperties
@EnableAutoConfiguration
class ContractCalculatorAPIControllerTest {
    @LocalServerPort
    private val port = 0

    private var uri: String? = null

    @PostConstruct
    fun init() {
        uri = URIFactory.testURI(port, CONTRACT_CALCULATOR_ENDPOINT)
    }

    @MockBean
    var contractCalculatorService: ContractCalculatorService? = null

    @Test
    @Throws(IOException::class)
    fun givenValidRequestedRemuneration_whenRequestingSuggestedContracts_thenCalculatedSuggestedContractsReturned() {
        val expectedResponseJson = FileTestUtils.testResourceFileAsJson(VALID_JSON_FILE)

        val expectedData = JsonTestUtils.deserializeJson(
            expectedResponseJson,
            SuggestedContract::class.java
        ) as List<SuggestedContract>

        `when`(contractCalculatorService!!.suggestedContracts(695018, 72152864))
            .thenReturn(expectedData)

        RestAssured.with()
            .contentType(ContentType.JSON)
            .body(RequestedRemuneration(695018, 72152864))
            .`when`()
            .request("POST", uri)
            .then()
            .statusCode(HttpStatus.OK.value())
            .and()
            .body("", JsonValidatingMatcher.matchFullJsonCollection<Any>(expectedResponseJson))
    }

    companion object {
        private const val VALID_JSON_FILE = "json/tools/contract-calculator-valid.json"
        private const val CONTRACT_CALCULATOR_ENDPOINT = "/api/contract-calculator"
    }
}
