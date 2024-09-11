package org.wcl.mfn.ui.integration.uielements

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.wcl.mfn.config.ui.common.*
import org.wcl.mfn.config.url.UrlConfig
import org.wcl.mfn.ui.integration.TestConfig
import org.wcl.mfn.ui.integration.uielements.pageobjectmodel.HomePageModel

@ImportAutoConfiguration(ThymeleafAutoConfiguration::class)
@SpringBootTest(
    classes = [TestConfig::class, UrlConfig::class, NavigationBarConfig::class, PageTitleConfig::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class HomePageUITest {
    private var pageModel: HomePageModel? = null

    @Autowired
    private val urlConfig: UrlConfig? = null

    @Autowired
    private val navigationBarConfig: NavigationBarConfig? = null

    @Autowired
    private val pageTitleConfig: PageTitleConfig? = null

    @LocalServerPort
    private val port = 0

    @Autowired
    private val driver: WebDriver? = null

    @BeforeEach
    fun loadPage() {
        driver!![String.format(FULL_URL, port, urlConfig!!.homeUrl())]

        pageModel = navigationBarConfig?.let { HomePageModel(driver, it) }
    }

    @AfterEach
    fun shutdown() {
        driver?.quit()
    }

    @Test
    fun whenHomePageIsLoaded_thenNavigationBarIsPresent() {
        assertThat(pageModel!!.navigationBar()).isNotNull()
    }

    @Test
    fun whenHomePageIsLoaded_thenTitleIsCorrect() {
        assertThat(pageModel!!.title).isEqualTo(pageTitleConfig!!.homePageTitle()) //homePageTitle);
    }

    @Test
    fun whenHomePageIsLoaded_thenHomeLinkIsPresent() {
        assertThat(pageModel!!.homeLink())
            .isEqualTo(String.format(FULL_URL, port, urlConfig!!.homeUrl()))
    }

    @Test
    fun whenHomePageIsLoaded_thenContractCalculatorLinkIsPresent() {
        assertThat(pageModel!!.contractCalculatorLink())
            .isEqualTo(String.format(FULL_URL, port, urlConfig!!.contractCalculatorUrl()))
    }

    companion object {
        private const val FULL_URL = "http://localhost:%d%s"
    }
}
