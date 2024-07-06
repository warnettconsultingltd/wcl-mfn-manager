package org.wcl.mfn.ui.integration.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.wcl.mfn.ui.app.MFNHelperApplication;
import org.wcl.mfn.ui.integration.selenium.config.ElementIDConfig;
import org.wcl.mfn.ui.integration.selenium.config.HtmlAttributeConfig;
import org.wcl.mfn.ui.integration.selenium.pageobjectmodel.HomePageModel;

import static org.assertj.core.api.Assertions.assertThat;

@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)
@SpringBootTest(classes= {MFNHelperApplication.class, HtmlAttributeConfig.class},
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:application.properties",
                     "classpath:application-test.properties"})
@EnableConfigurationProperties
public class HomePageUITest {

    private static final String FULL_URL = "http://localhost:%d%s";

    private HomePageModel pageModel;

    @Autowired
    private HtmlAttributeConfig htmlAttributeConfig;

    @Autowired
    private ElementIDConfig elementIdConfig;

    @Value("${url.home}")
    private String homeUrl;

    @Value("${url.tools.contract-calculator}")
    private String contractCalculatorUrl;

    @Value("${page.home.title}")
    private String homePageTitle;

    @Value("${mfn.navbar}")
    private String mfnNavbar;

    @Value("${mfn.navbar.home}")
    private String mfnNavbarHomeLink;

    @Value("${mfn.navbar.contract-calculator}")
    private String mfnNavbarContractCalculatorLink;

    @LocalServerPort
    private int port;

    @Autowired
    private WebDriver driver;

    @BeforeEach
    public void loadPage() {
        driver.get(String.format(FULL_URL,port,homeUrl));

        pageModel = new HomePageModel(driver, htmlAttributeConfig, elementIdConfig);
    }

    @AfterEach
    public void shutdown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void whenHomePageIsLoaded_thenNavigationBarIsPresent() {
        assertThat(pageModel.navigationBar()).isNotNull();
    }

    @Test
    public void whenHomePageIsLoaded_thenTitleIsCorrect() {
        assertThat(pageModel.getTitle()).isEqualTo(homePageTitle);
    }

    @Test
    public void whenHomePageIsLoaded_thenHomeLinkIsPresentAndCorrect() {
        assertThat(pageModel.homeLink())
                .isEqualTo(String.format(FULL_URL,port,homeUrl));
    }

    @Test
    public void whenHomePageIsLoaded_thenContractCalculatorLinkIsPresentAndCorrect() {
        assertThat(pageModel.contractCalculatorLink())
                .isEqualTo(String.format(FULL_URL,port,contractCalculatorUrl));
    }
}
