package org.wcl.mfn.entities.contract.calculator

import jakarta.validation.Valid
import jakarta.validation.constraints.Size

@JvmRecord
data class SuggestedContract(
    val years: Int,
    val totalSalary: Int,
    val bonusPerYear: Int,
    val totalRemuneration: Int,
    val yearlyFigures: @Size(min = 2, max = 6) @Valid List<SuggestedYearlyContract>
)

