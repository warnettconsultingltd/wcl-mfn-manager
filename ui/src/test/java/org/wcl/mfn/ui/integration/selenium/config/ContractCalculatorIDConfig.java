package org.wcl.mfn.ui.integration.selenium.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-test.properties")
public class ContractCalculatorIDConfig {
    private final String navbar;
    private final String navbarHome;
    private final String navbarContractCalculator;
    private final String salaryLabel;
    private final String bonusLabel;
    private final String escalatorLabel;
    private final String escalator;
    private final String escalatorValue;
    private final String resetButton;
    private final String submitButton;

    public ContractCalculatorIDConfig(@Value("${mfn.navbar}") String navbar,
                                      @Value("${mfn.navbar.home}") String navbarHome,
                                      @Value("${mfn.navbar.contract-calculator}") String navbarContractCalculator,
                                      @Value("${mfn.contract-calculator.salary-label}") String salaryLabel,
                                      @Value("${mfn.contract-calculator.bonus-label}") String bonusLabel,
                                      @Value("${mfn.contract-calculator.escalator-label}") String escalatorLabel,
                                      @Value("${mfn.contract-calculator.escalator}") String escalator,
                                      @Value("${mfn.contract-calculator.escalator-value}") String escalatorValue,
                                      @Value("${mfn.contract-calculator.reset-button}") String resetButton,
                                      @Value("${mfn.contract-calculator.submit-button}") String submitButton) {
        this.navbar = navbar;
        this.navbarHome = navbarHome;
        this.navbarContractCalculator = navbarContractCalculator;
        this.salaryLabel = salaryLabel;
        this.bonusLabel = bonusLabel;
        this.escalatorLabel = escalatorLabel;
        this.escalator = escalator;
        this.escalatorValue = escalatorValue;
        this.resetButton = resetButton;
        this.submitButton = submitButton;
    }

    public String navbar() {
        return navbar;
    }

    public String navbarHome() {
        return navbarHome;
    }

    public String navbarContractCalculator() {
        return navbarContractCalculator;
    }

    public String salaryLabel() { return salaryLabel; }

    public String bonusLabel() { return bonusLabel; }

    public String escalatorLabel() { return escalatorLabel; }

    public String escalator() { return escalator; }

    public String escalatorValue() { return escalatorValue; }

    public String resetButton() { return resetButton; }

    public String submitButton() { return submitButton; }
}
