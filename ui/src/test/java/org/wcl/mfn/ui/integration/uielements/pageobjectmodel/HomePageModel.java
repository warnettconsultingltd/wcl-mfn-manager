package org.wcl.mfn.ui.integration.uielements.pageobjectmodel;

import org.openqa.selenium.*;
import org.wcl.mfn.ui.config.common.NavigationBarConfig;


public class HomePageModel {

    private WebDriver driver;
    private NavigationBarConfig navigationBarConfig;

    public HomePageModel(WebDriver driver, NavigationBarConfig navigationBarConfig) {
        this.driver = driver;
        this.navigationBarConfig = navigationBarConfig;
    }

    public WebElement navigationBar() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarId())).getFirst();
    }

    public String homeLink() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarHomeId())).getFirst()
                .getAttribute("href");
    }

    public String contractCalculatorLink() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarContractCalculatorId())).getFirst()
                .getAttribute("href");
    }

    public String title() {
        return driver.getTitle();
    }

}
