package org.wcl.mfn.api.controller.tools;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.wcl.mfn.entities.contract.calculator.*;
import org.wcl.mfn.exceptions.validation.InvalidParameterException;
import org.wcl.mfn.service.tools.ContractCalculatorService;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ContractCalculatorAPIControllerTest {
    private ContractCalculatorAPIController testController;

    @Mock
    private ContractCalculatorService mockService;

    @BeforeEach
    public void setupTestControllerAndMockService() {
        testController = new ContractCalculatorAPIController(mockService);
    }

    @Test
    public void whenValidRequestRemunerationSupplied_thenCorrectResultsSupplied() {
        final var requestRemuneration = new RequestedRemuneration(76, 773);

        final var mockedSuggestedContracts = List.<SuggestedContract>of(
                new SuggestedContract(1, 43, 6554653, 543543, List.of()),
                new SuggestedContract(2, 44, 6554654, 543544, List.of()),
                new SuggestedContract(3, 45, 6554655, 543545, List.of()),
                new SuggestedContract(4, 46, 6554656, 543546, List.of()),
                new SuggestedContract(5, 47, 6554657, 543547, List.of()),
                new SuggestedContract(6, 48, 6554658, 543548, List.of()));

        when(mockService.suggestedContracts(76, 773))
                .thenReturn(mockedSuggestedContracts);

        try {
            final var result = testController.calculateSuggestedContracts(requestRemuneration);
            assertThat(result.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
            assertThat(result.getBody()).isEqualTo(mockedSuggestedContracts);
        } catch (InvalidParameterException e) {
            fail("Error running test - " + e);
        }
    }

    @Test
    public void whenInvalidRequestRemunerationSupplied_thenExceptionThrown() {
        assertThatThrownBy(() -> {
            testController.calculateSuggestedContracts(null);
        }).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("Request remuneration value cannot be null");
    }
}
