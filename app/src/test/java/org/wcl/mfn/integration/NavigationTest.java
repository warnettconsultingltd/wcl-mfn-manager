package org.wcl.mfn.integration;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.wcl.mfn.MFNHelperApplication;


@SpringBootTest(classes = {MFNHelperApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@ExtendWith(SerenityJUnit5Extension.class)
public class NavigationTest {
    @Value("${url.home}")
    private String homePageUrl;

    @Value("${url.tools.contract-calculator}")
    private String contractCalculatorUrl;

    @Value("${mfn.navbar.home}")
    private String homeId;

    @Value("${mfn.navbar.tools}")
    private String toolsId;

    @Value("${mfn.navbar.contract-calculator}")
    private String contractCalculatorId;

    @Value("${page.home.title}")
    private String homePageTitle;

    @Value("${page.contract-calculator.title}")
    private String contractCalculatorTitle;
    
    @Managed
    private WebDriver driver;

    @LocalServerPort
    private int port;

    private Actor dylan;

    private static final String BASE_URL = "http://localhost:%d%s";
    private static final String ACTOR_NAME = "Dylan";
            
    @BeforeEach
    public void setupActor() {
        dylan = Actor.named(ACTOR_NAME).whoCan(BrowseTheWeb.with(driver));
    }

    @Test
    @DisplayName("Opens application on Home Page")
    public void opensApplicationOnHomePage() {
        dylan.attemptsTo(Open.url(String.format(BASE_URL, port, homePageUrl)));

        assertThat(driver.getTitle()).isEqualTo(homePageTitle);
        assertThat(driver.getCurrentUrl()).isEqualTo(String.format(BASE_URL, port, homePageUrl));
    }
        
    
    @Test
    @DisplayName("Navigate from home page to Contract Calculator page")
    public void  navigateFromHomePageToContractCalculatorPage() {
        dylan.attemptsTo(
                Open.url(String.format(BASE_URL, port, homePageUrl)),
                Click.on(By.id(toolsId)),
                Click.on(By.id(contractCalculatorId)));

        assertThat(driver.getTitle()).isEqualTo(contractCalculatorTitle);
        assertThat(driver.getCurrentUrl()).isEqualTo(String.format(BASE_URL, port, contractCalculatorUrl));
    }
}
