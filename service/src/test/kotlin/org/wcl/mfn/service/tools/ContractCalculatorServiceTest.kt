package org.wcl.mfn.service.tools

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.wcl.mfn.entities.contract.calculator.*
import org.wcl.mfn.exceptions.validation.InvalidParameterException
import kotlin.test.assertFailsWith

class ContractCalculatorServiceTest {
    private val service: ContractCalculatorService = ContractCalculatorService()

    @Test
    fun whenNegativeSalaryProvided_thenThrowException() {
        val thrownException = assertFailsWith<InvalidParameterException> {
            service.suggestedContracts(-1, 352667)
        }

        assertThat(thrownException.message, equalTo("Invalid requested salary - cannot be negative or zero"))
    }

    @Test
    fun whenZeroSalaryProvided_thenThrowException() {
        val thrownException = assertFailsWith<InvalidParameterException> {
            service.suggestedContracts(0, 35269)
        }

        assertThat(thrownException.message, equalTo("Invalid requested salary - cannot be negative or zero"))
    }

    @Test
    fun whenNegativeBonusProvided_thenThrowException() {
        val thrownException = assertFailsWith<InvalidParameterException> {
            service.suggestedContracts(23455, -1)
        }

        assertThat(thrownException.message, equalTo("Invalid requested bonus - cannot be negative or zero"))
    }

    @Test
    fun whenZeroBonusProvided_thenThrowException() {
        val thrownException = assertFailsWith<InvalidParameterException> {
            service.suggestedContracts(13257, 0)
        }

        assertThat(thrownException.message, equalTo("Invalid requested bonus - cannot be negative or zero"))
    }

    @Test
    fun whenValidParametersProvided_thenSuggestedContractsAreGenerated() {
        val suggestedContracts = service.suggestedContracts(564335, 3452267)

        assertThat(suggestedContracts, notNullValue())
        assertThat(suggestedContracts.size, equalTo(5))

        val expectedContracts = generateExpectedSuggestedContracts()
        assertThat(suggestedContracts, equalTo(expectedContracts))
    }

    private fun generateExpectedSuggestedContracts(): List<SuggestedContract> {
        return listOf(
            SuggestedContract(
                2, 2653933, 1726134, 6106201,
                listOf(
                    YearlyFigure(1, 1294601, 3020735),
                    YearlyFigure(2, 1359332, 3085466)
                )
            ),
            SuggestedContract(
                3, 2720820, 1150756, 6173088,
                listOf(
                    YearlyFigure(1, 863067, 2013823),
                    YearlyFigure(2, 906221, 2056977),
                    YearlyFigure(3, 951532, 2102288)
                )
            ),
            SuggestedContract(
                4, 2789950, 863067,  6242218,
                listOf(
                    YearlyFigure(1, 647301, 1510368),
                    YearlyFigure(2, 679667, 1542734),
                    YearlyFigure(3, 713650, 1576717),
                    YearlyFigure(4, 749332, 1612399)
                )
            ),
            SuggestedContract(
                5, 2861400,  690454, 6313670,
                listOf(
                    YearlyFigure(1, 517841, 1208295),
                    YearlyFigure(2, 543734, 1234188),
                    YearlyFigure(3, 570920, 1261374),
                    YearlyFigure(4, 599466, 1289920),
                    YearlyFigure(5, 629439, 1319893)
                )
            ),
            SuggestedContract(
                6, 2935259, 575378,6387527 ,
                listOf(
                    YearlyFigure(1, 431534, 1006912),
                    YearlyFigure(2, 453111, 1028489),
                    YearlyFigure(3, 475767, 1051145),
                    YearlyFigure(4, 499555, 1074933),
                    YearlyFigure(5, 524533, 1099911),
                    YearlyFigure(6, 550759, 1126137)
                )
            )
        )
    }
}