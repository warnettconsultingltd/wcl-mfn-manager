package org.wcl.mfn.ui.integration.uielements.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.wcl.mfn.ui.integration.uielements.config.ContractCalculatorIDConfig;
import org.wcl.mfn.ui.integration.uielements.config.HtmlAttributeConfig;

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
    }

    public WebElement suggestedContractsTable() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsTable()));
    }

    public WebElement suggestedContractsMainHeader() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsMainHeader()));
    }

    public WebElement suggestedContractsSubHeaderYears() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsSubHeaderYears()));
    }

    public WebElement suggestedContractsSubHeaderSalary() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsSubHeaderSalary()));
    }

    public WebElement suggestedContractsSubHeaderRemuneration() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsSubHeaderRemuneration()));
    }

    public WebElement suggestedContractsSubHeaderContractYear() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsSubHeaderContractYear()));
    }

    public WebElement suggestedContractsSubHeaderContractYearSalary() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsSubHeaderContractYearSalary()));
    }

    public WebElement suggestedContractsSubHeaderContractYearlyBonus() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsSubHeaderContractYearlyBonus()));
    }

    public WebElement suggestedContractsSubHeaderContractYearlyTotal() {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsSubHeaderContractYearlyTotal()));
    }

    public WebElement contractYears(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsContractYears()+yearIndex));
    }

    public WebElement totalSalary(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsTotalSalary()+yearIndex));
    }

    public WebElement totalRemuneration(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsTotalRemuneration()+yearIndex));
    }

    public WebElement currentYear(int index) {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsCurrentYear()+index));
    }

    public WebElement yearSalary(int index) {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsYearSalary()+index));
    }

    public WebElement bonusPerYear(int index) {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsBonusPerYear() + index));
    }

    public WebElement totalPerYear(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorIdConfig.suggestedContractsTotalPerYear()+yearIndex));
    }


}
