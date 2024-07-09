package org.wcl.mfn.ui.integration.uielements.pageobjectmodel;

import org.openqa.selenium.*;
import org.wcl.mfn.ui.integration.uielements.config.*;

public class HomePageModel {
    private final WebDriver driver;
    private final HtmlAttributeConfig htmlAttributeConfig;
    private final ElementIDConfig elementIdConfig;

    public HomePageModel(WebDriver driver,
                         HtmlAttributeConfig htmlAttributeConfig,
                         ElementIDConfig elementIdConfig) {
        this.driver = driver;
        this.htmlAttributeConfig = htmlAttributeConfig;
        this.elementIdConfig = elementIdConfig;
    }

    public WebElement navigationBar() {
        return driver.findElements(By.id(elementIdConfig.navbar())).getFirst();
    }

    public String homeLink() {
        return driver.findElements(By.id(elementIdConfig.navbarHome())).getFirst()
                .getAttribute(htmlAttributeConfig.link());
    }

    public String contractCalculatorLink() {
        return driver.findElements(By.id(elementIdConfig.navbarContractCalculator())).getFirst()
                .getAttribute(htmlAttributeConfig.link());
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
