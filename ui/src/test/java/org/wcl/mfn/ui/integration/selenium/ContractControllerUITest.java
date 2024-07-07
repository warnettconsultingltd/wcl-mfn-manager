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
import org.wcl.mfn.ui.integration.selenium.config.ContractCalculatorIDConfig;
import org.wcl.mfn.ui.integration.selenium.config.HtmlAttributeConfig;
import org.wcl.mfn.ui.integration.selenium.pageobjectmodel.ContractControllerPageModel;

import static org.assertj.core.api.Assertions.assertThat;

@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)
@SpringBootTest(classes= {MFNHelperApplication.class, HtmlAttributeConfig.class},
                webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:application.properties",
                     "classpath:application-test.properties"})
@EnableConfigurationProperties
public class ContractControllerUITest {

    private static final String FULL_URL = "http://localhost:%d%s";

    private ContractControllerPageModel pageModel;

    @Autowired
    private HtmlAttributeConfig htmlAttributeConfig;

    @Autowired
    private ContractCalculatorIDConfig contractCalculatorIdConfig;

    @Value("${url.home}")
    private String homeUrl;

    @Value("${url.tools.contract-calculator}")
    private String contractCalculatorUrl;

    @Value("${page.contract-calculator.title}")
    private String contractCalculatorPageTitle;

    @LocalServerPort
    private int port;

    @Autowired
    private WebDriver driver;

    @BeforeEach
    public void loadPage() {
        driver.get(String.format(FULL_URL,port,contractCalculatorUrl));

        pageModel = new ContractControllerPageModel(driver, htmlAttributeConfig, contractCalculatorIdConfig);
    }

    @AfterEach
    public void shutdown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenNavigationBarIsPresent() {
        assertThat(pageModel.navigationBar()).isNotNull();
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenTitleIsCorrect() {
        assertThat(pageModel.getTitle()).isEqualTo(contractCalculatorPageTitle);
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenHomeLinkIsPresentAndCorrect() {
        assertThat(pageModel.homeLink())
                .isEqualTo(String.format(FULL_URL,port,homeUrl));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenContractCalculatorLinkIsPresentAndCorrect() {
        assertThat(pageModel.contractCalculatorLink())
                .isEqualTo(String.format(FULL_URL,port,contractCalculatorUrl));
    }

    // Contract Parameters Tests
    @Test
    public void whenContractControllerPageIsLoaded_thenSalaryLabelIsPresentAndCorrect() {
        assertThat(pageModel.salaryLabel().getText())
                .isEqualTo("Minimum Salary");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenBonusLabelIsPresentAndCorrect() {
        assertThat(pageModel.bonusLabel().getText())
                .isEqualTo("Bonus Required");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenEscalatorLabelIsPresentAndCorrect() {
        assertThat(pageModel.escalatorLabel().getText())
                .isEqualTo("Escalator %");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenEscalatorIsPresentAndCorrect() {
        assertThat(pageModel.escalator()).isNotNull();
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenEscalatorOutputIsPresentAndCorrect() {
        assertThat(pageModel.escalatorValue().getText())
                .isEqualTo("5");
    }
    @Test
    public void whenContractControllerPageIsLoaded_thenResetButtonIsPresentAndCorrect() {
        assertThat(pageModel.resetButton().getAttribute("value"))
                .isEqualTo("Reset");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSubmitButtonIsPresentAndCorrect() {
        assertThat(pageModel.submitButton().getAttribute("value"))
                .isEqualTo("Submit");
    }
}
