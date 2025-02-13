package org.wcl.mfn.ui.integration.uielements.pageobjectmodel;

import org.openqa.selenium.*;
import org.wcl.mfn.ui.config.common.NavigationBarConfig;
import org.wcl.mfn.ui.config.tools.ContractCalculatorConfig;


public class ContractControllerPageModel {
        private WebDriver driver;
        private NavigationBarConfig navigationBarConfig;
        private ContractCalculatorConfig contractCalculatorConfig;

        public ContractControllerPageModel(final WebDriver driver, final NavigationBarConfig navigationBarConfig,
                                           final ContractCalculatorConfig contractCalculatorConfig) {
            this.driver = driver;
            this.navigationBarConfig = navigationBarConfig;
            this.contractCalculatorConfig = contractCalculatorConfig;
        }

    public WebElement navigationBar()  {
        return driver.findElements(By.id(navigationBarConfig.navigationBarId())).getFirst();
    }

    public String homeLink() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarHomeId())).getFirst()
                .getAttribute("href");
    }

    public WebElement toolsMenu() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarToolsId())).getFirst();
    }

    public String contractCalculatorLink() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarContractCalculatorId())).getFirst()
                .getAttribute("href");
    }

    public String title() {
        return driver.getTitle();
    }


    public WebElement salaryLabel() {
        return driver.findElement(By.id(contractCalculatorConfig.salaryLabel()));
    }

    public WebElement bonusLabel() {
        return driver.findElement(By.id(contractCalculatorConfig.bonusLabel()));
    }

    public WebElement escalatorLabel() {
        return driver.findElement(By.id(contractCalculatorConfig.escalatorLabel()));
    }

    public WebElement escalator() {
        return driver.findElement(By.id(contractCalculatorConfig.escalator()));
    }

    public WebElement escalatorValue() {
        return driver.findElement(By.id(contractCalculatorConfig.escalatorValue()));
    }

    public WebElement resetButton() {
        return driver.findElement(By.id(contractCalculatorConfig.resetButton()));
    }

    public WebElement submitButton() {
        return driver.findElement(By.id(contractCalculatorConfig.submitButton()));
    }

    public WebElement suggestedContractsTable() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTable()));
    }

    public WebElement suggestedContractsMainHeader() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsMainHeader()));
    }

    public WebElement suggestedContractsSubHeaderYears() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderYears()));
    }

    public WebElement suggestedContractsSubHeaderSalary() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderSalary()));
    }

    public WebElement suggestedContractsSubHeaderRemuneration() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderRemuneration()));
    }

    public WebElement suggestedContractsSubHeaderContractYear() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYear()));
    }

    public WebElement suggestedContractsSubHeaderContractYearSalary() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYearSalary()));
    }

    public WebElement suggestedContractsSubHeaderContractYearlyBonus() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYearlyBonus()));
    }

    public WebElement suggestedContractsSubHeaderContractYearlyTotal() {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYearlyTotal()));
    }

    public WebElement contractYears(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsContractYears() + yearIndex));
    }

    public WebElement totalSalary(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTotalSalary() + yearIndex));
    }

    public WebElement totalRemuneration(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTotalRemuneration() + yearIndex));
    }

    public WebElement currentYear(int index) {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsCurrentYear() + index));
    }

    public WebElement yearSalary(int index) {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsYearSalary() + index));
    }

    public WebElement bonusPerYear(int index) {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsBonusPerYear() + index));
    }

    public WebElement totalPerYear(int yearIndex) {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTotalPerYear() + yearIndex));
    }
}
