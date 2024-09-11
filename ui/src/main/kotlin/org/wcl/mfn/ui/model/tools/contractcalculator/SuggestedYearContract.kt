package org.wcl.mfn.ui.model.tools.contractcalculator

import java.util.stream.IntStream

data class SuggestedYearContract(
    val years: Int, val totalSalary: Int, val totalRemuneration: Int,
    val yearlySalaries: List<Int>, val bonusPerYear: Int, val totalsPerYear: List<Int>
) {
    fun listedYears(): List<Int> {
        return IntStream.rangeClosed(1, years).boxed().toList()
    }
}
