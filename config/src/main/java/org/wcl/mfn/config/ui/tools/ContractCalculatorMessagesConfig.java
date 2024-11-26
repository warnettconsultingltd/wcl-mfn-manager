package org.wcl.mfn.config.ui.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:ui/tools/contract-calculator-messages.properties")
public class ContractCalculatorMessagesConfig {
    @Value("${mfn.contract-calculator.salary-label}")
    private String minSalary;

    @Value("${mfn.contract-calculator.bonus-label}")
    private String bonus;

    @Value("${mfn.contract-calculator.escalator-label}")
    private String escalator;

    @Value("${mfn.contract-calculator.reset-button}")
    private String reset;

    @Value("${mfn.contract-calculator.submit-button}")
    private String submit;

    public String minSalary() {
        return minSalary;
    }

    public String bonus() {
        return bonus;
    }

    public String escalator() {
        return escalator;
    }

    public String reset() {
        return reset;
    }

    public String submit() {
        return submit;
    }
}
