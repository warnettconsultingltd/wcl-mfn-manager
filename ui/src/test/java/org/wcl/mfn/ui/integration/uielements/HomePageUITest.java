package org.wcl.mfn.ui.integration.uielements;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.wcl.mfn.config.url.UrlConfig;
import org.wcl.mfn.ui.config.common.NavigationBarConfig;
import org.wcl.mfn.ui.config.common.PageTitleConfig;
import org.wcl.mfn.ui.integration.TestConfig;
import org.wcl.mfn.ui.integration.uielements.pageobjectmodel.HomePageModel;

import static org.assertj.core.api.Assertions.assertThat;

@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)
@SpringBootTest(
        classes = {TestConfig.class,UrlConfig.class, NavigationBarConfig.class, PageTitleConfig.class},
        webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageUITest {
    private HomePageModel pageModel;

    @Autowired
    private UrlConfig urlConfig;

    @Autowired
    private NavigationBarConfig navigationBarConfig;

    @Autowired
    private PageTitleConfig pageTitleConfig;

    @LocalServerPort
    private int port = 0;

    @Autowired
    private WebDriver driver;

    private static final String FULL_URL = "http://localhost:%d%s";

    @BeforeEach
    public void loadPage() {
        driver.get(String.format(FULL_URL, port, urlConfig.homeUrl()));

        pageModel = new HomePageModel(driver, navigationBarConfig);
    }

    @AfterEach
    public void shutdown() {
        driver.quit();
    }

    @Test
    public void whenHomePageIsLoaded_thenNavigationBarIsPresent() {
        assertThat(pageModel.navigationBar()).isNotNull();
    }

    @Test
    public void whenHomePageIsLoaded_thenTitleIsCorrect() {
        assertThat(driver.getTitle()).isEqualTo(pageTitleConfig.homePageTitle());
    }

    @Test
    public void whenHomePageIsLoaded_thenHomeLinkIsPresent() {
        assertThat(pageModel.homeLink())
                .isEqualTo(String.format(FULL_URL, port, urlConfig.homeUrl()));
    }

    @Test
    public void whenHomePageIsLoaded_thenContractCalculatorLinkIsPresent() {
        assertThat(pageModel.contractCalculatorLink())
                .isEqualTo(String.format(FULL_URL, port, urlConfig.contractCalculatorUrl()));
    }

}
