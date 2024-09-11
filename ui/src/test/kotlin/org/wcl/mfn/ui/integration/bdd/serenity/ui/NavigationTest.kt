package org.wcl.mfn.ui.integration.bdd.serenity.ui

import net.serenitybdd.annotations.Managed
import net.serenitybdd.junit5.SerenityJUnit5Extension
import net.serenitybdd.screenplay.Actor
import net.serenitybdd.screenplay.abilities.BrowseTheWeb
import net.serenitybdd.screenplay.actions.Click
import net.serenitybdd.screenplay.actions.Open
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.wcl.mfn.ui.app.MFNHelperApplication

@SpringBootTest(classes = [MFNHelperApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@ExtendWith(
    SerenityJUnit5Extension::class
)
class NavigationTest {
    @Value("\${url.home}")
    private val homeUrl: String? = null

    @Value("\${url.tools.contract-calculator}")
    private val contractCalculatorUrl: String? = null

    @Value("\${mfn.navbar.home}")
    private val homeId: String? = null

    @Value("\${mfn.navbar.tools}")
    private val toolsId: String? = null

    @Value("\${mfn.navbar.contract-calculator}")
    private val contractCalculatorId: String? = null

    @Value("\${page.home.title}")
    private val homeTitle: String? = null

    @Value("\${page.contract-calculator.title}")
    private val contractCalculatorTitle: String? = null

    @Managed
    private val driver: WebDriver? = null

    private var dylan: Actor? = null

    @LocalServerPort
    private val port = 0

    @BeforeEach
    fun setUpActor() {
        dylan = Actor.named(ACTOR_NAME).whoCan(BrowseTheWeb.with(driver))
    }

    @Test
    @DisplayName("Navigate from home page to Contract Calculator page")
    fun navigateFromHomePageToContractCalculatorPage() {
        dylan!!.attemptsTo(
            Open.url(String.format(BASE_URL, port, homeUrl)),
            Click.on(By.id(toolsId)),
            Click.on(By.id(contractCalculatorId))
        )

        assertThat(driver!!.title).isEqualTo(contractCalculatorTitle)
        assertThat(driver.currentUrl).isEqualTo(String.format(BASE_URL, port, contractCalculatorUrl))
    }

    @Test
    @DisplayName("Navigate from Contract Calculator page to home page")
    fun navigateFromContractCalculatorPageToHomePage() {
        dylan!!.attemptsTo(
            Open.url(String.format(BASE_URL, port, contractCalculatorUrl)),
            Click.on(By.id(homeId))
        )

        assertThat(driver!!.title).isEqualTo(homeTitle)
        assertThat(driver.currentUrl).isEqualTo(String.format(BASE_URL, port, homeUrl))
    }

    companion object {
        private const val BASE_URL = "http://localhost:%d%s"
        private const val ACTOR_NAME = "Dylan"
    }
}
