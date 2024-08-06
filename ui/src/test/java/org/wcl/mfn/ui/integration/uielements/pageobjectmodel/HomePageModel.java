package org.wcl.mfn.ui.integration.uielements.pageobjectmodel;

import org.openqa.selenium.*;
import org.wcl.mfn.config.ui.common.NavigationBarConfig;

public class HomePageModel {
    private final WebDriver driver;

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

    public String getTitle() {
        return driver.getTitle();
    }
}
