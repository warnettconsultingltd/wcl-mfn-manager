package org.wcl.mfn.service.tools

import org.junit.jupiter.api.*
import org.wcl.mfn.exceptions.validation.InvalidParameterException
import kotlin.test.assertFailsWith
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.equalTo

class ContractCalculatorServiceTest {
    private val service:ContractCalculatorService= ContractCalculatorService();

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
}