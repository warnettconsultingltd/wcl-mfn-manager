package org.wcl.mfn.ui.integration.uielements.pageobjectmodel

import org.openqa.selenium.*
import org.wcl.mfn.config.ui.common.NavigationBarConfig

class HomePageModel(private val driver: WebDriver, private val navigationBarConfig: NavigationBarConfig) {
    fun navigationBar(): WebElement {
        return driver.findElements(By.id(navigationBarConfig.navigationBarId())).first()
    }

    fun homeLink(): String {
        return driver.findElements(By.id(navigationBarConfig.navigationBarHomeId())).first()
            .getAttribute("href")
    }

    fun contractCalculatorLink(): String {
        return driver.findElements(By.id(navigationBarConfig.navigationBarContractCalculatorId())).first()
            .getAttribute("href")
    }

    val title: String
        get() = driver.title
}
