package org.wcl.mfn.ui.integration.uielements.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-test.properties")
public class ElementIDConfig {
    private final String navbar;
    private final String navbarHome;
    private final String navbarContractCalculator;

    public ElementIDConfig(@Value("${mfn.navbar}") String navbar,
                           @Value("${mfn.navbar.home}") String navbarHome,
                           @Value("${mfn.navbar.contract-calculator}") String navbarContractCalculator) {
        this.navbar = navbar;
        this.navbarHome = navbarHome;
        this.navbarContractCalculator = navbarContractCalculator;
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
}
