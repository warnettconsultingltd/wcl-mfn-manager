package org.wcl.mfn.service.tools

import org.springframework.stereotype.Service
import org.wcl.mfn.entities.contract.calculator.*
import org.wcl.mfn.exceptions.validation.InvalidParameterException
import kotlin.math.*

@Service
class ContractCalculatorService {
    fun suggestedContracts(requestedSalary: Int, requestedBonus: Int): List<SuggestedContract> {
        if (requestedSalary <= 0) {
            throw InvalidParameterException("Invalid requested salary - cannot be negative or zero");
        }
        if (requestedBonus <= 0) {
            throw InvalidParameterException("Invalid requested bonus - cannot be negative or zero");
        }

        return generateSuggestedContracts(requestedSalary, requestedBonus)
    }

    private fun generateSuggestedContracts(requestedSalary: Int, requestedBonus: Int): List<SuggestedContract> {
        val yearsList = IntRange(2, 6).toList()
        return yearsList.stream().map { n -> generateSuggestedContract(n, requestedSalary, requestedBonus) }.toList()
    }

    private fun generateSuggestedContract(numberOfYears: Int, requestedSalary: Int, requestedBonus: Int): SuggestedContract {
        val bonusPerYear = ceil((requestedBonus / numberOfYears.toDouble())).toInt()
        val startingSalary = generateStartingSalary(requestedSalary, requestedBonus, bonusPerYear)
        val yearlyFigures = generateYearlyFigures(numberOfYears, startingSalary, bonusPerYear)

        return SuggestedContract(
            numberOfYears,
            yearlyFigures.stream().map { yf -> yf.salary }.toList().sum(),
            bonusPerYear,
            yearlyFigures.stream().map { yf -> yf.yearlyRemuneration }.toList().sum(),
            yearlyFigures
        )
    }

    private fun generateStartingSalary(requestedSalary: Int, requestedBonus: Int, bonusPerYear: Int): Int {
        return if (requestedSalary > requestedBonus) {
            requestedSalary
        } else {
            ceil(bonusPerYear * 0.75).toInt()
        }
    }

    private fun generateYearlyFigures(numberOfYears: Int, startingSalary: Int, bonusPerYear: Int): List<YearlyFigure> {
        return IntRange(1, numberOfYears).toList().stream()
            .map { n -> generateYearlyFigure(n, startingSalary, bonusPerYear) }.toList()
    }

    private fun generateYearlyFigure(year: Int, startingSalary: Int, bonusPerYear: Int): YearlyFigure {
        val salary: Int = if (year == 1) {
            startingSalary
        } else {
            ceil(startingSalary.toDouble() * (1.05.pow(year - 1))).toInt()
        }
        return YearlyFigure(year, salary, salary + bonusPerYear)
    }
}
