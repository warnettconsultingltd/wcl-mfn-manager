package org.wcl.mfn.ui.model;

import java.util.List;
import java.util.stream.IntStream;

public record SuggestedYearContract(int years, int totalSalary, int totalRemuneration,
                                    List<Integer> yearlySalaries, int bonusPerYear, List<Integer> totalsPerYear) {
    public List<Integer> listedYears() {
        return IntStream.rangeClosed(1,years).boxed().toList();
    }
}
