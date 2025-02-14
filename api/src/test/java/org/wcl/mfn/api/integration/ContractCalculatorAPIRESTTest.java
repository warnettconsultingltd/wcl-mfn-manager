package org.wcl.mfn.api.integration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hosuaby.inject.resources.junit.jupiter.GivenJsonResource;
import io.hosuaby.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcl.mfn.api.controller.tools.ContractCalculatorAPIController;
import org.wcl.mfn.api.exceptionhandler.MFNExceptionHandler;
import org.wcl.mfn.entities.contract.calculator.RequestedRemuneration;
import org.wcl.mfn.entities.contract.calculator.SuggestedContract;
import org.wcl.mfn.entities.contract.calculator.SuggestedYearlyContract;
import org.wcl.mfn.exceptions.InvalidParameterException;
import org.wcl.mfn.service.tools.ContractCalculatorService;

import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestWithResources
class ContractCalculatorAPIRESTTest {
    private static final String VALID_JSON_EXPECTED_RESPONSE_FILE = "expected-contract-calculator-valid.json";

    private MockMvc mockMvc;
    private ContractCalculatorService mockService;

    @GivenJsonResource(VALID_JSON_EXPECTED_RESPONSE_FILE)
    JsonNode expectedJson;

    @BeforeEach
    void setupTestEnvironment() {
        mockService = mock(ContractCalculatorService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new ContractCalculatorAPIController(mockService))
                .setControllerAdvice(new MFNExceptionHandler()).build();
    }

    @Test
    void whenValidRequestMade_thenSuggestedContractsReturned() {
        final var requestedRemuneration = new RequestedRemuneration(567, 8665);

        final var objectMapper = new ObjectMapper();
        try {
            final var json = objectMapper.writeValueAsString(requestedRemuneration);

            when(mockService.suggestedContracts(567, 8665))
                    .thenReturn(getExpectedSuggestedContracts());

            mockMvc.perform(MockMvcRequestBuilders.post("/api/contract-calculator")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .content(json))
                    .andExpect(status().isOk())
                    .andExpect(content().json(expectedJson.toString()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<SuggestedContract> getExpectedSuggestedContracts() {
        return List.of(new SuggestedContract(2, 55467514, 36076432, 127620378,
                        List.of(new SuggestedYearlyContract(1, 27057324, 63133756),
                                new SuggestedYearlyContract(2, 28410190, 64486622))),
                new SuggestedContract(3, 56865476, 24050955, 129018341,
                        List.of(new SuggestedYearlyContract(1, 18038216, 42089171),
                                new SuggestedYearlyContract(2, 18940127, 42991082),
                                new SuggestedYearlyContract(3, 19887133, 43938088))),
                new SuggestedContract(4, 58310225, 18038216, 130463089,
                        List.of(new SuggestedYearlyContract(1, 13528662, 31566878),
                                new SuggestedYearlyContract(2, 14205095, 32243311),
                                new SuggestedYearlyContract(3, 14915350, 32953566),
                                new SuggestedYearlyContract(4, 15661118, 33699334))),
                new SuggestedContract(5, 59803523, 14430573, 131956388,
                        List.of(new SuggestedYearlyContract(1, 10822930, 25253503),
                                new SuggestedYearlyContract(2, 11364077, 25794650),
                                new SuggestedYearlyContract(3, 11932281, 26362854),
                                new SuggestedYearlyContract(4, 12528895, 26959468),
                                new SuggestedYearlyContract(5, 13155340, 27585913))),
                new SuggestedContract(6, 61347182, 12025477, 133500044,
                        List.of(new SuggestedYearlyContract(1, 9019108, 21044585),
                                new SuggestedYearlyContract(2, 9470063, 21495540),
                                new SuggestedYearlyContract(3, 9943566, 21969043),
                                new SuggestedYearlyContract(4, 10440744, 22466221),
                                new SuggestedYearlyContract(5, 10962781, 22988258),
                                new SuggestedYearlyContract(6, 11510920, 23536397)))
        );
    }

    @Test
    void whenNoParametersSupplied_thenErrorReturned() {
        try {
            final var objectMapper = new ObjectMapper();
            mockMvc.perform(MockMvcRequestBuilders.post("/api/contract-calculator")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .content(objectMapper.writeValueAsString(null)))
                    .andExpect(status().isBadRequest())
                    .andExpect(result -> Assertions.assertInstanceOf(HttpMessageNotReadableException.class, result.getResolvedException()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void whenZeroSalarySupplied_thenErrorReturned() throws Exception {
        final var objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/contract-calculator")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(new RequestedRemuneration(0, 1))))
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertInstanceOf(InvalidParameterException.class, result.getResolvedException()))
                .andExpect(result -> Assertions.assertEquals("MFN-CONTRACT-001 : Salary and Bonus must be positive, non-zero values",
                        Objects.requireNonNull(result.getResolvedException()).getMessage()));

    }

    @Test
    void whenZeroBonusSupplied_thenErrorReturned() throws Exception {
        final var objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/contract-calculator")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(new RequestedRemuneration(3, 0))))
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertInstanceOf(InvalidParameterException.class, result.getResolvedException()))
                .andExpect(result -> Assertions.assertEquals("MFN-CONTRACT-001 : Salary and Bonus must be positive, non-zero values",
                        Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }
}
