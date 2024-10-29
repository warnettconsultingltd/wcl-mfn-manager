package org.wcl.mfn.ui.integration.uielements

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.wcl.mfn.config.ui.common.*
import org.wcl.mfn.config.ui.tools.*
import org.wcl.mfn.config.url.UrlConfig
import org.wcl.mfn.ui.integration.TestConfig
import org.wcl.mfn.ui.integration.uielements.pageobjectmodel.ContractControllerPageModel
import java.util.stream.IntStream

@ImportAutoConfiguration(ThymeleafAutoConfiguration::class)
@SpringBootTest(
    classes = [TestConfig::class, UrlConfig::class, PageTitleConfig::class, ContractCalculatorConfig::class, NavigationBarConfig::class, ContractCalculatorConfig::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ContractCalculatorPageUITest {
    private var pageModel: ContractControllerPageModel? = null

    @Autowired
    private val urlConfig: UrlConfig? = null

    @Autowired
    private val pageTitleConfig: PageTitleConfig? = null

    @Autowired
    private val navBarConfig: NavigationBarConfig? = null

    @Autowired
    private val contractCalculatorConfig: ContractCalculatorConfig? = null

    @Autowired
    private val contractCalculatorMessagesConfig: ContractCalculatorMessagesConfig? = null

    @LocalServerPort
    private val port = 0

    @Autowired
    private val driver: WebDriver? = null

    @BeforeEach
    fun loadPage() {
        driver!![String.format(
            FULL_URL,
            port,
            urlConfig!!.contractCalculatorUrl()
        )]

        pageModel = contractCalculatorConfig?.let { navBarConfig?.let { it1 ->
            ContractControllerPageModel(driver,
                it1, it)
        } }
    }

    @AfterEach
    fun shutdown() {
        driver?.quit()
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenNavigationBarIsPresent() {
        Assertions.assertThat(pageModel!!.navigationBar()).isNotNull()
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenTitleIsCorrect() {
        Assertions.assertThat(pageModel!!.title).isEqualTo(pageTitleConfig!!.contractCalculatorPageTitle())
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenHomeLinkIsPresent() {
        Assertions.assertThat(pageModel!!.homeLink())
            .isEqualTo(String.format(FULL_URL, port, urlConfig!!.homeUrl()))
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenToolsMenuIsPresent() {
        Assertions.assertThat(pageModel!!.toolsMenu()).isNotNull()
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenContractCalculatorLinkIsPresent() {
        Assertions.assertThat(pageModel!!.contractCalculatorLink())
            .isEqualTo(String.format(FULL_URL, port, urlConfig!!.contractCalculatorUrl()))
    }

    // Contract Parameters Tests
    @Test
    fun whenContractControllerPageIsLoaded_thenSalaryLabelIsPresent() {
        Assertions.assertThat(pageModel!!.salaryLabel().text)
            .isEqualTo("Minimum Salary")
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenBonusLabelIsPresent() {
        Assertions.assertThat(pageModel!!.bonusLabel().text)
            .isEqualTo("Bonus Requested")
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenEscalatorLabelIsPresent() {
        Assertions.assertThat(pageModel!!.escalatorLabel().text)
            .isEqualTo("Escalator %")
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenEscalatorIsPresent() {
        Assertions.assertThat(pageModel!!.escalator()).isNotNull()
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenEscalatorOutputIsPresent() {
        Assertions.assertThat(pageModel!!.escalatorValue().text)
            .isEqualTo("5")
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenResetButtonIsPresent() {
        Assertions.assertThat(pageModel!!.resetButton().getAttribute("value"))
            .isEqualTo("Reset")
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSubmitButtonIsPresent() {
        Assertions.assertThat(pageModel!!.submitButton().getAttribute("value"))
            .isEqualTo("Submit")
    }


    // SUGGESTED CONTRACTS
    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsTableIsPresent() {
        Assertions.assertThat(pageModel!!.suggestedContractsTable())
            .isNotNull()
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsTableMainHeaderIsPresent() {
        Assertions.assertThat(pageModel!!.suggestedContractsMainHeader().text)
            .isEqualTo("Suggested Contract Details")
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsTableSubHeadersArePresent() {
        val subHeaders = listOf(
            pageModel!!.suggestedContractsSubHeaderYears(),
            pageModel!!.suggestedContractsSubHeaderSalary(),
            pageModel!!.suggestedContractsSubHeaderRemuneration(),
            pageModel!!.suggestedContractsSubHeaderContractYear(),
            pageModel!!.suggestedContractsSubHeaderContractYearSalary(),
            pageModel!!.suggestedContractsSubHeaderContractYearlyBonus(),
            pageModel!!.suggestedContractsSubHeaderContractYearlyTotal()
        )

        val expectedSubHeaderTexts = listOf(
            "Years", "Total Salary", "Total Remuneration", "Contract Year", "Salary",
            "Bonus per Year", "Total per Year"
        )


        IntStream.range(0, subHeaders.size).forEach { i: Int ->
            Assertions.assertThat(
                subHeaders[i].text
            ).isEqualTo(expectedSubHeaderTexts[i])
        }
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsContractYearsArePresent() {
        IntStream.rangeClosed(1, 5).forEach { i: Int ->
            Assertions.assertThat(
                pageModel!!.contractYears(i).text
            ).isEqualTo((i + 1).toString())
        }
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsContractTotalSalaryArePresent() {
        IntStream.rangeClosed(1, 5).forEach { i: Int ->
            Assertions.assertThat(
                pageModel!!.totalSalary(i).text
            ).isEqualTo(0.toString())
        }
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsContractTotalRemunerationArePresent() {
        IntStream.rangeClosed(1, 5).forEach { i: Int ->
            Assertions.assertThat(
                pageModel!!.totalRemuneration(i).text
            ).isEqualTo(0.toString())
        }
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsContractCurrentYearsArePresent() {
        val contractYearsValues = listOf(1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6)
        IntStream.rangeClosed(1, 20).forEach { i: Int ->
            run {
                System.out.println("i = " + i + " curr year = " +  pageModel!!.currentYear(i).text + " expected = " + contractYearsValues[i-1].toString())
                Assertions.assertThat(
                    pageModel!!.currentYear(i).text
                ).isEqualTo(contractYearsValues[i-1].toString())

            }
        }
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsContractCurrentYearSalaryArePresent() {
        IntStream.rangeClosed(1, 20).forEach { i: Int ->
            Assertions.assertThat(
                pageModel!!.yearSalary(i).text
            ).isEqualTo(0.toString())
        }
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsContractBonusPerYearArePresent() {
        IntStream.rangeClosed(1, 5).forEach { i: Int ->
            Assertions.assertThat(
                pageModel!!.bonusPerYear(i).text
            ).isEqualTo(0.toString())
        }
    }

    @Test
    fun whenContractControllerPageIsLoaded_thenSuggestedContractsContractCurrentTotalPerYearArePresent() {
        IntStream.rangeClosed(1, 20).forEach { i: Int ->
            Assertions.assertThat(
                pageModel!!.totalPerYear(i).text
            ).isEqualTo(0.toString())
        }
    }

    companion object {
        private const val FULL_URL = "http://localhost:%d%s"
    }
}
