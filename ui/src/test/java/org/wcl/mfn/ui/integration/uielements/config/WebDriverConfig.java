package org.wcl.mfn.ui.integration.uielements.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.springframework.context.annotation.*;

@Configuration
public class WebDriverConfig {

    @Bean
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        final var options = new ChromeOptions();
        options.addArguments("--headless=new");

        return new ChromeDriver(options);
    }
}
