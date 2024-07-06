package org.wcl.mfn.ui.integration.selenium.pageobjectmodel;

import org.openqa.selenium.*;

public class HomePageModel {
    private WebDriver driver;

    private By navigationBar = By.id("mfn-navbar") ;
    private By homeLink = By.id("mfn-navbar-home");
    private By contractCalculatorLink = By.id("mfn-navbar-contract-calculator");

    public HomePageModel(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement navigationBar() {
        return driver.findElements(navigationBar).getFirst();
    }

    public String homeLink() {
        return driver.findElements(homeLink).getFirst().getAttribute("href");
    }

    public String contractCalculatorLink() {
        return driver.findElements(contractCalculatorLink).getFirst().getAttribute("href");
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
