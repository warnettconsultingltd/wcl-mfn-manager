package org.wcl.mfn.ui.integration.uielements;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.wcl.mfn.ui.app.MFNHelperApplication;
import org.wcl.mfn.ui.integration.uielements.config.*;
import org.wcl.mfn.ui.integration.uielements.pageobjectmodel.ContractControllerPageModel;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)
@SpringBootTest(classes = {MFNHelperApplication.class, HtmlAttributeConfig.class},
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
        driver.get(String.format(FULL_URL, port, contractCalculatorUrl));

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
    public void whenContractControllerPageIsLoaded_thenHomeLinkIsPresent() {
        assertThat(pageModel.homeLink())
                .isEqualTo(String.format(FULL_URL, port, homeUrl));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenContractCalculatorLinkIsPresent() {
        assertThat(pageModel.contractCalculatorLink())
                .isEqualTo(String.format(FULL_URL, port, contractCalculatorUrl));
    }

    // Contract Parameters Tests
    @Test
    public void whenContractControllerPageIsLoaded_thenSalaryLabelIsPresent() {
        assertThat(pageModel.salaryLabel().getText())
                .isEqualTo("Minimum Salary");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenBonusLabelIsPresent() {
        assertThat(pageModel.bonusLabel().getText())
                .isEqualTo("Bonus Required");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenEscalatorLabelIsPresent() {
        assertThat(pageModel.escalatorLabel().getText())
                .isEqualTo("Escalator %");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenEscalatorIsPresent() {
        assertThat(pageModel.escalator()).isNotNull();
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenEscalatorOutputIsPresent() {
        assertThat(pageModel.escalatorValue().getText())
                .isEqualTo("5");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenResetButtonIsPresent() {
        assertThat(pageModel.resetButton().getAttribute("value"))
                .isEqualTo("Reset");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSubmitButtonIsPresent() {
        assertThat(pageModel.submitButton().getAttribute("value"))
                .isEqualTo("Submit");
    }


    // SUGGESTED CONTRACTS
    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsTableIsPresent() {
        assertThat(pageModel.suggestedContractsTable())
                .isNotNull();
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsTableMainHeaderIsPresent() {
        assertThat(pageModel.suggestedContractsMainHeader().getText())
                .isEqualTo("Suggested Contract Details");
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsTableSubHeadersArePresent() {
        final var subHeaders = List.of(pageModel.suggestedContractsSubHeaderYears(),
                pageModel.suggestedContractsSubHeaderSalary(),
                pageModel.suggestedContractsSubHeaderRemuneration(),
                pageModel.suggestedContractsSubHeaderContractYear(),
                pageModel.suggestedContractsSubHeaderContractYearSalary(),
                pageModel.suggestedContractsSubHeaderContractYearlyBonus(),
                pageModel.suggestedContractsSubHeaderContractYearlyTotal()
        );

        final var expectedSubHeaderTexts = List.of("Years", "Total Salary", "Total Remuneration", "Contract Year", "Salary",
                "Bonus per Year", "Total per Year");


        IntStream.range(0, subHeaders.size()).forEach(i ->
                assertThat(subHeaders.get(i).getText()).isEqualTo(expectedSubHeaderTexts.get(i)));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsContractYearsArePresent() {
        IntStream.rangeClosed(1,5).forEach(i ->
            assertThat(pageModel.contractYears(i).getText()).isEqualTo(Integer.toString(i+1)));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsContractTotalSalaryArePresent() {
        IntStream.rangeClosed(1,5).forEach(i ->
                assertThat(pageModel.totalSalary(i).getText()).isEqualTo(Integer.toString(0)));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsContractTotalRemunerationArePresent() {
        IntStream.rangeClosed(1,5).forEach(i ->
                assertThat(pageModel.totalRemuneration(i).getText()).isEqualTo(Integer.toString(0)));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsContractCurrentYearsArePresent() {
        final var contractYearsValues = List.of(1,2,1,2,3,1,2,3,4,1,2,3,4,5,1,2,3,4,5,6);
        IntStream.rangeClosed(1,20).forEach(i ->
                assertThat(pageModel.currentYear(i).getText()).isEqualTo(Integer.toString(contractYearsValues.get(i-1))));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsContractCurrentYearSalaryArePresent() {
        IntStream.rangeClosed(1,20).forEach(i ->
                assertThat(pageModel.yearSalary(i).getText()).isEqualTo(Integer.toString(0)));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsContractBonusPerYearArePresent() {
        IntStream.rangeClosed(1,5).forEach(i ->
                assertThat(pageModel.bonusPerYear(i).getText()).isEqualTo(Integer.toString(0)));
    }

    @Test
    public void whenContractControllerPageIsLoaded_thenSuggestedContractsContractCurrentTotalPerYearArePresent() {
        IntStream.rangeClosed(1,20).forEach(i ->
                assertThat(pageModel.totalPerYear(i).getText()).isEqualTo(Integer.toString(0)));
    }

}