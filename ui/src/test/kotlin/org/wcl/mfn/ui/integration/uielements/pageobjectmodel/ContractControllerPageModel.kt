package org.wcl.mfn.ui.integration.uielements.pageobjectmodel

import org.openqa.selenium.*
import org.wcl.mfn.config.ui.common.NavigationBarConfig
import org.wcl.mfn.config.ui.tools.ContractCalculatorConfig

class ContractControllerPageModel(
    private val driver: WebDriver,
    private val navigationBarConfig: NavigationBarConfig,
    private val contractCalculatorConfig: ContractCalculatorConfig
) {
    fun navigationBar(): WebElement {
        return driver.findElements(By.id(navigationBarConfig.navigationBarId())).first()
    }

    fun homeLink(): String {
        return driver.findElements(By.id(navigationBarConfig.navigationBarHomeId())).first()
            .getAttribute("href")
    }

    fun toolsMenu(): WebElement {
        return driver.findElements(By.id(navigationBarConfig.navigationBarToolsId())).first()
    }

    fun contractCalculatorLink(): String {
        return driver.findElements(By.id(navigationBarConfig.navigationBarContractCalculatorId())).first()
            .getAttribute("href")
    }

    val title: String
        get() = driver.title


    fun salaryLabel(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.salaryLabel()))
    }

    fun bonusLabel(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.bonusLabel()))
    }

    fun escalatorLabel(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.escalatorLabel()))
    }

    fun escalator(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.escalator()))
    }

    fun escalatorValue(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.escalatorValue()))
    }

    fun resetButton(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.resetButton()))
    }

    fun submitButton(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.submitButton()))
    }

    fun suggestedContractsTable(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTable()))
    }

    fun suggestedContractsMainHeader(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsMainHeader()))
    }

    fun suggestedContractsSubHeaderYears(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderYears()))
    }

    fun suggestedContractsSubHeaderSalary(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderSalary()))
    }

    fun suggestedContractsSubHeaderRemuneration(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderRemuneration()))
    }

    fun suggestedContractsSubHeaderContractYear(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYear()))
    }

    fun suggestedContractsSubHeaderContractYearSalary(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYearSalary()))
    }

    fun suggestedContractsSubHeaderContractYearlyBonus(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYearlyBonus()))
    }

    fun suggestedContractsSubHeaderContractYearlyTotal(): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsSubHeaderContractYearlyTotal()))
    }

    fun contractYears(yearIndex: Int): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsContractYears() + yearIndex))
    }

    fun totalSalary(yearIndex: Int): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTotalSalary() + yearIndex))
    }

    fun totalRemuneration(yearIndex: Int): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTotalRemuneration() + yearIndex))
    }

    fun currentYear(index: Int): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsCurrentYear() + index))
    }

    fun yearSalary(index: Int): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsYearSalary() + index))
    }

    fun bonusPerYear(index: Int): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsBonusPerYear() + index))
    }

    fun totalPerYear(yearIndex: Int): WebElement {
        return driver.findElement(By.id(contractCalculatorConfig.suggestedContractsTotalPerYear() + yearIndex))
    }
}
