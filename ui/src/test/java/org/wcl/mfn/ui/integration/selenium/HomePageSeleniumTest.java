package org.wcl.mfn.ui.integration.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.wcl.mfn.ui.app.MFNHelperApplication;

import static org.assertj.core.api.Assertions.assertThat;

@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)
@SpringBootTest(classes= MFNHelperApplication.class,
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:application.properties",
                     "classpath:application-test.properties"})
public class HomePageSeleniumTest {

    private static final String FULL_URL = "http://localhost:%d%s";

    @Value("${url.home}")
    private String homeUrl;

    @Value("${url.tools.contract-calculator}")
    private String contractCalculatorUrl;

    @Value("${page.home.title}")
    private String homePageTitle;

    @Value("${tag.link}")
    private String linkTag;

    @Value("${mfn.navbar}")
    private String mfnNavbar;

    @Value("${mfn.navbar.home}")
    private String mfnNavbarHomeLink;

    @Value("${mfn.navbar.contract-calculator}")
    private String mfnNavbarContractCalculatorLink;

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeEach
    public void loadPage() {
        final var options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.get(String.format(FULL_URL,port,homeUrl));
    }

    @AfterEach
    public void shutdown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void whenHomePageIsLoaded_thenNavigationBarIsPresent() {
        assertThat(driver.findElements(By.id(mfnNavbar))).hasSize(1);
    }

    @Test
    public void whenHomePageIsLoaded_thenTitleIsCorrect() {
        assertThat(driver.getTitle()).isEqualTo(homePageTitle);
    }

    @Test
    public void whenHomePageIsLoaded_thenHomeLinkIsPresentAndCorrect() {
        final var mfnNavbarHome = driver.findElements(By.id(mfnNavbarHomeLink));
        assertThat(mfnNavbarHome).hasSize(1);
        assertThat(mfnNavbarHome.getFirst().getAttribute(linkTag))
                .isEqualTo(String.format(FULL_URL,port,homeUrl));
    }

    @Test
    public void whenHomePageIsLoaded_thenContractCalculatorLinkIsPresentAndCorrect() {
        final var mfnNavbarContractCalculator = driver.findElements(By.id(mfnNavbarContractCalculatorLink));
        assertThat(mfnNavbarContractCalculator).hasSize(1);
        assertThat(mfnNavbarContractCalculator.getFirst().getAttribute(linkTag))
                .isEqualTo(String.format(FULL_URL,port,contractCalculatorUrl));
    }
}
