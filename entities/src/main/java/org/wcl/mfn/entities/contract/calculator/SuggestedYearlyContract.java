package org.wcl.mfn.entities.contract.calculator;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record SuggestedYearlyContract(@Min(1L) @Max(6L) int year, int salary, int yearlyRemuneration) {
}
