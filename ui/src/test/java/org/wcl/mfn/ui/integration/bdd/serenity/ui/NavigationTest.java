package org.wcl.mfn.ui.integration.bdd.serenity.ui;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.wcl.mfn.ui.app.MFNHelperApplication;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {MFNHelperApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@ExtendWith(SerenityJUnit5Extension.class)
public class NavigationTest {
    private static final String baseUrl = "http://localhost:%d%s";

    @Value("${url.home}")
    private String homeUrl;
    @Value("${url.tools.contract-calculator}")
    private String contractCalculatorUrl;

    @Value("${mfn.navbar.home}")
    private String homeId;
    @Value("${mfn.navbar.tools}")
    private String toolsId;
    @Value("${mfn.navbar.contract-calculator}")
    private String contractCalculatorId;

    @Value("${page.home.title}")
    private String homeTitle;
    @Value("${page.contract-calculator.title}")
    private String contractCalculatorTitle;

    @Managed
    private WebDriver driver;

    private Actor dylan;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUpActor() {
        dylan = Actor.named("Dylan").whoCan(BrowseTheWeb.with(driver));
    }

    @Test
    @DisplayName("Navigate from home page to Contract Calculator page")
    public void navigateFromHomePageToContractCalculatorPage() {
        dylan.attemptsTo(
                Open.url(String.format(baseUrl, port,homeUrl)),
                Click.on(By.id(toolsId)),
                Click.on(By.id(contractCalculatorId))
        );

        assertThat(driver.getTitle()).isEqualTo(contractCalculatorTitle);
        assertThat(driver.getCurrentUrl()).isEqualTo(String.format(baseUrl, port, contractCalculatorUrl));
    }

    @Test
    @DisplayName("Navigate from Contract Calculator page to home page")
    public void navigateFromContractCalculatorPageToHomePage() {
        dylan.attemptsTo(
                Open.url(String.format(baseUrl, port, contractCalculatorUrl)),
                Click.on(By.id(homeId))
        );

        assertThat(driver.getTitle()).isEqualTo(homeTitle);
        assertThat(driver.getCurrentUrl()).isEqualTo(String.format(baseUrl, port, homeUrl));
    }

}
