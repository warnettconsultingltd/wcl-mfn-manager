package org.wcl.mfn.config.ui.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("ui/tools/contract-calculator.properties")
public class ContractCalculatorConfig {
    @Value("${contract-calculator.view.attribute.contract_parameters}")
    private String contractParameters;
    @Value("${contract-calculator.view.attribute.suggested_contracts}")
    private String suggestedContracts;

    @Value("${mfn.contract-calculator.salary-label}")
    private String salaryLabel;
    @Value("${mfn.contract-calculator.bonus-label}")
    private String bonusLabel;
    @Value("${mfn.contract-calculator.escalator-label}")
    private String escalatorLabel;
    @Value("${mfn.contract-calculator.escalator}")
    private String escalator;
    @Value("${mfn.contract-calculator.escalator-value}")
    private String escalatorValue;
    @Value("${mfn.contract-calculator.reset-button}")
    private String resetButton;
    @Value("${mfn.contract-calculator.submit-button}")
    private String submitButton;
    @Value("${mfn.contract-calculator.suggested-contracts.table}")
    private String suggestedContractsTable;
    @Value("${mfn.contract-calculator.suggested-contracts.main-header}")
    private String suggestedContractsMainHeader;
    @Value("${mfn.contract-calculator.suggested-contracts.sub-header.years}")
    private String suggestedContractsSubHeaderYears;
    @Value("${mfn.contract-calculator.suggested-contracts.sub-header.salary}")
    private String suggestedContractsSubHeaderSalary;
    @Value("${mfn.contract-calculator.suggested-contracts.sub-header.remuneration}")
    private String suggestedContractsSubHeaderRemuneration;
    @Value("${mfn.contract-calculator.suggested-contracts.sub-header.contract-year}")
    private String suggestedContractsSubHeaderContractYear;
    @Value("${mfn.contract-calculator.suggested-contracts.sub-header.contract-year-salary}")
    private String suggestedContractsSubHeaderContractYearSalary;
    @Value("${mfn.contract-calculator.suggested-contracts.sub-header.contract-year-bonus}")
    private String suggestedContractsSubHeaderContractYearlyBonus;
    @Value("${mfn.contract-calculator.suggested-contracts.sub-header.contract-year-total}")
    private String suggestedContractsSubHeaderContractYearlyTotal;
    @Value("${mfn.contract-calculator.suggested-contracts.contract-years}")
    private String suggestedContractsContractYears;
    @Value("${mfn.contract-calculator.suggested-contracts.total-salary}")
    private String suggestedContractsTotalSalary;
    @Value("${mfn.contract-calculator.suggested-contracts.total-remuneration}")
    private String suggestedContractsTotalRemuneration;
    @Value("${mfn.contract-calculator.suggested-contracts.current-year}")
    private String suggestedContractsCurrentYear;
    @Value("${mfn.contract-calculator.suggested-contracts.year-salary}")
    private String suggestedContractsYearSalary;
    @Value("${mfn.contract-calculator.suggested-contracts.bonus-per-year}")
    private String suggestedContractsBonusPerYear;
    @Value("${mfn.contract-calculator.suggested-contracts.total-per-year}")
    private String suggestedContractsTotalPerYear;

    public String contractParameters() { return contractParameters; }
    public String suggestedContracts() { return suggestedContracts;}

    public String salaryLabel() { return salaryLabel; }
    public String bonusLabel() { return bonusLabel; }
    public String escalatorLabel() { return escalatorLabel; }
    public String escalator() { return escalator; }
    public String escalatorValue() { return escalatorValue; }
    public String resetButton() { return resetButton; }
    public String submitButton() { return submitButton; }

    public String suggestedContractsTable() { return suggestedContractsTable;}
    public String suggestedContractsMainHeader() { return suggestedContractsMainHeader;}
    public String suggestedContractsSubHeaderYears() { return suggestedContractsSubHeaderYears;}
    public String suggestedContractsSubHeaderSalary() { return suggestedContractsSubHeaderSalary;}
    public String suggestedContractsSubHeaderRemuneration() { return suggestedContractsSubHeaderRemuneration;}
    public String suggestedContractsSubHeaderContractYear() { return suggestedContractsSubHeaderContractYear;}
    public String suggestedContractsSubHeaderContractYearSalary() { return suggestedContractsSubHeaderContractYearSalary;}
    public String suggestedContractsSubHeaderContractYearlyBonus() { return suggestedContractsSubHeaderContractYearlyBonus;}
    public String suggestedContractsSubHeaderContractYearlyTotal() { return suggestedContractsSubHeaderContractYearlyTotal;}
    public String suggestedContractsContractYears() { return suggestedContractsContractYears; }
    public String suggestedContractsTotalSalary() { return suggestedContractsTotalSalary; }
    public String suggestedContractsTotalRemuneration() { return suggestedContractsTotalRemuneration; }
    public String suggestedContractsCurrentYear() { return suggestedContractsCurrentYear; }
    public String suggestedContractsYearSalary() { return suggestedContractsYearSalary; }
    public String suggestedContractsBonusPerYear() { return suggestedContractsBonusPerYear; }
    public String suggestedContractsTotalPerYear() { return suggestedContractsTotalPerYear; }
}
