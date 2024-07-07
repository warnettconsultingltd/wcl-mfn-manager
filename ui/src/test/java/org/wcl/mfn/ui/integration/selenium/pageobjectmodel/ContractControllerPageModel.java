package org.wcl.mfn.ui.integration.selenium.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.wcl.mfn.ui.integration.selenium.config.ContractCalculatorIDConfig;
import org.wcl.mfn.ui.integration.selenium.config.HtmlAttributeConfig;

public class ContractControllerPageModel {
    private final WebDriver driver;
    private final HtmlAttributeConfig htmlAttributeConfig;
    private final ContractCalculatorIDConfig contractCalculatorIdConfig;

    public ContractControllerPageModel(WebDriver driver,
                                       HtmlAttributeConfig htmlAttributeConfig,
                                       ContractCalculatorIDConfig contractCalculatorIdConfig) {
        this.driver = driver;
        this.htmlAttributeConfig = htmlAttributeConfig;
        this.contractCalculatorIdConfig = contractCalculatorIdConfig;
    }

    public WebElement navigationBar() {
        return driver.findElements(By.id(contractCalculatorIdConfig.navbar())).getFirst();
    }

    public String homeLink() {
        return driver.findElements(By.id(contractCalculatorIdConfig.navbarHome())).getFirst()
                .getAttribute(htmlAttributeConfig.link());
    }

    public String contractCalculatorLink() {
        return driver.findElements(By.id(contractCalculatorIdConfig.navbarContractCalculator())).getFirst()
                .getAttribute(htmlAttributeConfig.link());
    }

    public String getTitle() {
        return driver.getTitle();
    }


    public WebElement salaryLabel() {
        return driver.findElement(By.id(contractCalculatorIdConfig.salaryLabel()));
    }

    public WebElement bonusLabel() {
        return driver.findElement(By.id(contractCalculatorIdConfig.bonusLabel()));
    }

    public WebElement escalatorLabel() {
        return driver.findElement(By.id(contractCalculatorIdConfig.escalatorLabel()));
    }

    public WebElement escalator() {
        return driver.findElement(By.id(contractCalculatorIdConfig.escalator()));
    }

    public WebElement escalatorValue() {
        return driver.findElement(By.id(contractCalculatorIdConfig.escalatorValue()));
    }

    public WebElement resetButton() {
        return driver.findElement(By.id(contractCalculatorIdConfig.resetButton()));
    }

    public WebElement submitButton() {
        return driver.findElement(By.id(contractCalculatorIdConfig.submitButton()));
    }}
