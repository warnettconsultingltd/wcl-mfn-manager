package org.wcl.mfn.entities.contract.calculator;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SuggestedContract(int years, int totalSalary, int bonusPerYear, int totalRemuneration,
                                @Size(min = 2, max = 6) @Valid List<SuggestedYearlyContract> yearlyFigures) {
}
