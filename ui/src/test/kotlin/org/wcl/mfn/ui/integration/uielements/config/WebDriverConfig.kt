package org.wcl.mfn.ui.integration.uielements.config

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.*
import org.springframework.context.annotation.*

@Configuration
open class WebDriverConfig {
    @get:Bean
    open val driver: WebDriver
        get() {
            WebDriverManager.chromedriver().setup()
            val options = ChromeOptions()
            options.addArguments("--headless=new")

            return ChromeDriver(options)
        }
}
