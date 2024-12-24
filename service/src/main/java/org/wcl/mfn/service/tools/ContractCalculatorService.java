package org.wcl.mfn.service.tools;

import org.springframework.stereotype.Service;
import org.wcl.mfn.entities.contract.calculator.*;
import org.wcl.mfn.exceptions.validation.InvalidParameterException;

import java.util.List;
import java.util.stream.IntStream;


@Service
public final  class ContractCalculatorService {
    private static final double BONUS_PERCENTAGE_OF_SALARY = 0.75;
    private static final int MIN_YEARS = 2;
    private static final int MAX_YEARS = 6;
    public static final double SALARY_SCALING_FACTOR = 1.05;

    public List<SuggestedContract> suggestedContracts(int requestedSalary, int requestedBonus) throws InvalidParameterException {
        if (requestedSalary <= 0) {
            throw new InvalidParameterException("Invalid requested salary - cannot be negative or zero");
        }
        if (requestedBonus <= 0) {
            throw new InvalidParameterException("Invalid requested bonus - cannot be negative or zero");
        }

        return IntStream.rangeClosed(MIN_YEARS,MAX_YEARS).mapToObj(n -> generateSuggestedContract(n, requestedSalary, requestedBonus)).toList();
    }

    private SuggestedContract generateSuggestedContract(int numberOfYears, int requestedSalary, int requestedBonus) {
        final var bonusPerYear = (int)Math.ceil((requestedBonus / (double)numberOfYears));
        final var startingSalary = generateStartingSalary(requestedSalary, requestedBonus, bonusPerYear);
        final var yearlyFigures = generateYearlyFigures(numberOfYears, startingSalary, bonusPerYear);

        return new SuggestedContract(
                numberOfYears,
                yearlyFigures.stream().mapToInt(SuggestedYearlyContract::salary).sum(),
                bonusPerYear,
                yearlyFigures.stream().mapToInt(SuggestedYearlyContract::yearlyRemuneration).sum(),
                yearlyFigures
        );
    }

    private int generateStartingSalary(int requestedSalary, int requestedBonus, int bonusPerYear) {
        if (requestedSalary > requestedBonus) {
            return requestedSalary;
        } else {
            return (int)Math.ceil(bonusPerYear * BONUS_PERCENTAGE_OF_SALARY);
        }
    }

    private List<SuggestedYearlyContract> generateYearlyFigures(int numberOfYears, int startingSalary, int bonusPerYear) {
        return IntStream.rangeClosed(1, numberOfYears)
                .mapToObj(n -> generateYearlyFigure(n, startingSalary, bonusPerYear)).toList();
    }

    private SuggestedYearlyContract generateYearlyFigure(int year, int startingSalary, int bonusPerYear)  {
        int salary = startingSalary;

        if (year > 1) {
            salary = (int)Math.ceil(startingSalary * (Math.pow(SALARY_SCALING_FACTOR,year - 1)));
        }
        return new SuggestedYearlyContract(year, salary, salary + bonusPerYear);
    }
}
