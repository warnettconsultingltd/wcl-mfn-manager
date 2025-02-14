package org.wcl.mfn.service.tools;

import org.junit.jupiter.api.*;
import org.wcl.mfn.entities.contract.calculator.*;
import org.wcl.mfn.exceptions.InvalidParameterException;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContractCalculatorServiceTest {
    private ContractCalculatorService service;
    
    @BeforeEach
    public void setupTest() {
        service = new ContractCalculatorService();
    }

    @Test
    public void whenNegativeSalaryProvided_thenThrowException() {
        final var thrownException = assertThrows(InvalidParameterException.class,
                () -> service.suggestedContracts(-1, 352667));

        assertThat(thrownException.getMessage(), equalTo("Invalid requested salary - cannot be negative or zero"));
    }

    @Test
    public void whenZeroSalaryProvided_thenThrowException() {
        final var thrownException = assertThrows(InvalidParameterException.class,
                () -> service.suggestedContracts(0, 35269));

        assertThat(thrownException.getMessage(), equalTo("Invalid requested salary - cannot be negative or zero"));
    }

    @Test
    public void whenNegativeBonusProvided_thenThrowException() {
        final var thrownException = assertThrows(InvalidParameterException.class,
                () -> service.suggestedContracts(23455, -1));

        assertThat(thrownException.getMessage(), equalTo("Invalid requested bonus - cannot be negative or zero"));
    }

    @Test
    public void whenZeroBonusProvided_thenThrowException() {
        final var thrownException = assertThrows(InvalidParameterException.class,
                () -> service.suggestedContracts(13257, 0));

        assertThat(thrownException.getMessage(), equalTo("Invalid requested bonus - cannot be negative or zero"));
    }

    @Test
    public void whenValidParametersProvided_thenSuggestedContractsAreGenerated() {
        final List<SuggestedContract> suggestedContracts;
        try {
            suggestedContracts = service.suggestedContracts(564335, 3452267);

            assertThat(suggestedContracts, notNullValue());
            assertThat(suggestedContracts.size(), equalTo(5));

            final var expectedContracts = generateExpectedSuggestedContracts();
            assertThat(suggestedContracts, equalTo(expectedContracts));
        } catch (InvalidParameterException e) {
            throw new RuntimeException(e);
        }
    }

    private List<SuggestedContract> generateExpectedSuggestedContracts()  {
        return List.of(
                new SuggestedContract(
                        2, 2653933, 1726134, 6106201,
                        List.of(
                                new SuggestedYearlyContract(1, 1294601, 3020735),
                                new SuggestedYearlyContract(2, 1359332, 3085466)
                        )
                ),
                new SuggestedContract(
                        3, 2720820, 1150756, 6173088,
                        List.of(
                                new SuggestedYearlyContract(1, 863067, 2013823),
                                new SuggestedYearlyContract(2, 906221, 2056977),
                                new SuggestedYearlyContract(3, 951532, 2102288)
                        )
                ),
                new SuggestedContract(
                        4, 2789950, 863067,  6242218,
                        List.of(
                                new SuggestedYearlyContract(1, 647301, 1510368),
                                new SuggestedYearlyContract(2, 679667, 1542734),
                                new SuggestedYearlyContract(3, 713650, 1576717),
                                new SuggestedYearlyContract(4, 749332, 1612399)
                        )
                ),
                new SuggestedContract(
                        5, 2861400,  690454, 6313670,
                        List.of(
                                new SuggestedYearlyContract(1, 517841, 1208295),
                                new SuggestedYearlyContract(2, 543734, 1234188),
                                new SuggestedYearlyContract(3, 570920, 1261374),
                                new SuggestedYearlyContract(4, 599466, 1289920),
                                new SuggestedYearlyContract(5, 629439, 1319893)
                        )
                ),
                new SuggestedContract(
                        6, 2935259, 575378,6387527 ,
                        List.of(
                                new SuggestedYearlyContract(1, 431534, 1006912),
                                new SuggestedYearlyContract(2, 453111, 1028489),
                                new SuggestedYearlyContract(3, 475767, 1051145),
                                new SuggestedYearlyContract(4, 499555, 1074933),
                                new SuggestedYearlyContract(5, 524533, 1099911),
                                new SuggestedYearlyContract(6, 550759, 1126137)
                        )
                )
        );
    }
}