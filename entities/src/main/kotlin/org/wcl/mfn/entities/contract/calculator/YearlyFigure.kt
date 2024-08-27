package org.wcl.mfn.entities.contract.calculator

import jakarta.validation.constraints.*

@JvmRecord
data class YearlyFigure(
    val year: @Min(1L) @Max(6L) Int?,
    val salary: Int,
    val yearlyRemuneration: Int
)
