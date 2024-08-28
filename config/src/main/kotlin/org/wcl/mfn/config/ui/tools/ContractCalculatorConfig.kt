package org.wcl.mfn.config.ui.tools

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.*

@Configuration
@PropertySource("classpath:ui/tools/contract-calculator.properties")
open class ContractCalculatorConfig {
    @Value("\${contract-calculator.view.attribute.contract_parameters}")
    private val contractParameters: String? = null

    @Value("\${contract-calculator.view.attribute.suggested_contracts}")
    private val suggestedContracts: String? = null

    @Value("\${mfn.contract-calculator.salary-label-id}")
    private val salaryLabel: String? = null

    @Value("\${mfn.contract-calculator.bonus-label-id}")
    private val bonusLabel: String? = null

    @Value("\${mfn.contract-calculator.escalator-label-id}")
    private val escalatorLabel: String? = null

    @Value("\${mfn.contract-calculator.escalator-id}")
    private val escalator: String? = null

    @Value("\${mfn.contract-calculator.escalator.default}")
    private val escalatorDefault = 0

    @Value("\${mfn.contract-calculator.escalator.max}")
    private val escalatorMax = 0

    @Value("\${mfn.contract-calculator.escalator.step}")
    private val escalatorStep = 0

    @Value("\${mfn.contract-calculator.escalator-value-id}")
    private val escalatorValue: String? = null

    @Value("\${mfn.contract-calculator.reset-button-id}")
    private val resetButton: String? = null

    @Value("\${mfn.contract-calculator.submit-button-id}")
    private val submitButton: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.table}")
    private val suggestedContractsTable: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.main-header}")
    private val suggestedContractsMainHeader: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.sub-header.years}")
    private val suggestedContractsSubHeaderYears: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.sub-header.salary}")
    private val suggestedContractsSubHeaderSalary: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.sub-header.remuneration}")
    private val suggestedContractsSubHeaderRemuneration: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.sub-header.contract-year}")
    private val suggestedContractsSubHeaderContractYear: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.sub-header.contract-year-salary}")
    private val suggestedContractsSubHeaderContractYearSalary: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.sub-header.contract-year-bonus}")
    private val suggestedContractsSubHeaderContractYearlyBonus: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.sub-header.contract-year-total}")
    private val suggestedContractsSubHeaderContractYearlyTotal: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.contract-years}")
    private val suggestedContractsContractYears: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.total-salary}")
    private val suggestedContractsTotalSalary: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.total-remuneration}")
    private val suggestedContractsTotalRemuneration: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.current-year}")
    private val suggestedContractsCurrentYear: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.year-salary}")
    private val suggestedContractsYearSalary: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.bonus-per-year}")
    private val suggestedContractsBonusPerYear: String? = null

    @Value("\${mfn.contract-calculator.suggested-contracts.total-per-year}")
    private val suggestedContractsTotalPerYear: String? = null

    fun contractParameters(): String? {
        return contractParameters
    }

    fun suggestedContracts(): String? {
        return suggestedContracts
    }

    fun salaryLabel(): String? {
        return salaryLabel
    }

    fun bonusLabel(): String? {
        return bonusLabel
    }

    fun escalatorLabel(): String? {
        return escalatorLabel
    }

    fun escalator(): String? {
        return escalator
    }

    fun escalatorValue(): String? {
        return escalatorValue
    }

    fun escalatorDefault(): Int {
        return escalatorDefault
    }

    fun escalatorMax(): Int {
        return escalatorMax
    }

    fun escalatorStep(): Int {
        return escalatorStep
    }

    fun resetButton(): String? {
        return resetButton
    }

    fun submitButton(): String? {
        return submitButton
    }

    fun suggestedContractsTable(): String? {
        return suggestedContractsTable
    }

    fun suggestedContractsMainHeader(): String? {
        return suggestedContractsMainHeader
    }

    fun suggestedContractsSubHeaderYears(): String? {
        return suggestedContractsSubHeaderYears
    }

    fun suggestedContractsSubHeaderSalary(): String? {
        return suggestedContractsSubHeaderSalary
    }

    fun suggestedContractsSubHeaderRemuneration(): String? {
        return suggestedContractsSubHeaderRemuneration
    }

    fun suggestedContractsSubHeaderContractYear(): String? {
        return suggestedContractsSubHeaderContractYear
    }

    fun suggestedContractsSubHeaderContractYearSalary(): String? {
        return suggestedContractsSubHeaderContractYearSalary
    }

    fun suggestedContractsSubHeaderContractYearlyBonus(): String? {
        return suggestedContractsSubHeaderContractYearlyBonus
    }

    fun suggestedContractsSubHeaderContractYearlyTotal(): String? {
        return suggestedContractsSubHeaderContractYearlyTotal
    }

    fun suggestedContractsContractYears(): String? {
        return suggestedContractsContractYears
    }

    fun suggestedContractsTotalSalary(): String? {
        return suggestedContractsTotalSalary
    }

    fun suggestedContractsTotalRemuneration(): String? {
        return suggestedContractsTotalRemuneration
    }

    fun suggestedContractsCurrentYear(): String? {
        return suggestedContractsCurrentYear
    }

    fun suggestedContractsYearSalary(): String? {
        return suggestedContractsYearSalary
    }

    fun suggestedContractsBonusPerYear(): String? {
        return suggestedContractsBonusPerYear
    }

    fun suggestedContractsTotalPerYear(): String? {
        return suggestedContractsTotalPerYear
    }
}
