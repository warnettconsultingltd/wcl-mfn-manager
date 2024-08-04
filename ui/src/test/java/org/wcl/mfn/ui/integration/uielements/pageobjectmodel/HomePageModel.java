package org.wcl.mfn.ui.integration.uielements.pageobjectmodel;

import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wcl.mfn.config.ui.common.NavigationBarConfig;
import org.wcl.mfn.ui.integration.uielements.config.*;

@Component
public class HomePageModel {
    private final WebDriver driver;
//    private final HtmlAttributeConfig htmlAttributeConfig;
//    private final ElementIDConfig elementIdConfig;
    @Autowired
    private NavigationBarConfig navigationBarConfig;


    public HomePageModel(WebDriver driver) {//,
//                         HtmlAttributeConfig htmlAttributeConfig){ //},
//                         ElementIDConfig elementIdConfig,
//                         NavigationBarConfig navigationBarConfig) {
        this.driver = driver;
//        this.htmlAttributeConfig = htmlAttributeConfig;
//        this.elementIdConfig = elementIdConfig;
//        this.navigationBarConfig = navigationBarConfig;
    }

    public WebElement navigationBar() {
//        return driver.findElements(By.id(elementIdConfig.navbar())).getFirst();
        return driver.findElements(By.id(navigationBarConfig.navigationBarId())).getFirst();
    }

    public String homeLink() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarHomeId())).getFirst()
                .getAttribute("html");
//        return driver.findElements(By.id(elementIdConfig.navbarHome())).getFirst()
//                .getAttribute(htmlAttributeConfig.link());
    }

    public String contractCalculatorLink() {
        return driver.findElements(By.id(navigationBarConfig.navigationBarContractCalculatorId())).getFirst()
                .getAttribute("html");
//        return driver.findElements(By.id(elementIdConfig.navbarContractCalculator())).getFirst()
//                .getAttribute(htmlAttributeConfig.link());
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
