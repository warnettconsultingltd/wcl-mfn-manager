package org.wcl.mfn.entities.contract.calculator

import jakarta.validation.constraints.*

@JvmRecord
data class SuggestedYearlyContract(
    val year: @Min(1L) @Max(6L) Int?,
    val salary: Int,
    val yearlyRemuneration: Int
)
