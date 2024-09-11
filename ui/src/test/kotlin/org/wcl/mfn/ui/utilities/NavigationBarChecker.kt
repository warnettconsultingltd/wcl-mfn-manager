package org.wcl.mfn.ui.utilities

import org.assertj.core.api.Assertions
import org.jsoup.Jsoup

object NavigationBarChecker {
    private const val HREF_ATTRIBUTE = "href"
    private const val A_ATTRIBUTE = "a"

    private const val HOME_TEXT = "Home"
    private const val HOME_LINK = "/"

    private const val CONTRACT_CALCULATOR_TEXT = "Contract Calculator"
    private const val CONTRACT_CALCULATOR_LINK = "/contract-calculator"

    private const val TOOLS_MENU_TEXT = "Tools"

    fun checkNavigationBarContents(htmlContent: String) {
        val links = Jsoup.parse(htmlContent).select(A_ATTRIBUTE)

        Assertions.assertThat(links.size).isEqualTo(3)
        Assertions.assertThat(links[0].attr(HREF_ATTRIBUTE)).isEqualTo(HOME_LINK)
        Assertions.assertThat(links[0].text()).isEqualTo(HOME_TEXT)
        Assertions.assertThat(links[1].text()).isEqualTo(TOOLS_MENU_TEXT)
        Assertions.assertThat(links[2].attr(HREF_ATTRIBUTE)).isEqualTo(CONTRACT_CALCULATOR_LINK)
        Assertions.assertThat(links[2].text()).isEqualTo(CONTRACT_CALCULATOR_TEXT)
    }
}
