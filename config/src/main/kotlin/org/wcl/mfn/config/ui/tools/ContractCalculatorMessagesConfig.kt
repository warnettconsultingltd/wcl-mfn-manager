package org.wcl.mfn.config.ui.tools

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.*

@Configuration
@PropertySource("classpath:ui/tools/contract-calculator-messages.properties")
open class ContractCalculatorMessagesConfig {
    @Value("\${mfn.contract-calculator.salary-label}")
    private val minSalary: String? = null

    @Value("\${mfn.contract-calculator.bonus-label}")
    private val bonus: String? = null

    @Value("\${mfn.contract-calculator.escalator-label}")
    private val escalator: String? = null

    @Value("\${mfn.contract-calculator.reset-button}")
    private val reset: String? = null

    @Value("\${mfn.contract-calculator.submit-button}")
    private val submit: String? = null

    fun minSalary(): String? {
        return minSalary
    }

    fun bonus(): String? {
        return bonus
    }

    fun escalator(): String? {
        return escalator
    }

    fun reset(): String? {
        return reset
    }

    fun submit(): String? {
        return submit
    }
}
