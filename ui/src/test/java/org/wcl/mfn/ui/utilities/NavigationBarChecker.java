package org.wcl.mfn.ui.utilities;

import org.jsoup.Jsoup;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationBarChecker {

    private static final String HREF_ATTRIBUTE = "href";
    private static final String A_ATTRIBUTE = "a";

    private static final String HOME_TEXT = "Home";
    private static final String HOME_LINK = "/";

    private static final String CONTRACT_CALCULATOR_TEXT = "Contract Calculator";
    private static final String CONTRACT_CALCULATOR_LINK = "/contract-calculator";

    private static final String TOOLS_MENU_TEXT = "Tools";

    public static void checkNavigationBarContents(final String htmlContent) {
        final var links = Jsoup.parse(htmlContent).select(A_ATTRIBUTE);

        assertThat(links.size()).isEqualTo(3);
        assertThat(links.get(0).attr(HREF_ATTRIBUTE)).isEqualTo(HOME_LINK);
        assertThat(links.get(0).text()).isEqualTo(HOME_TEXT);
        assertThat(links.get(1).text()).isEqualTo(TOOLS_MENU_TEXT);
        assertThat(links.get(2).attr(HREF_ATTRIBUTE)).isEqualTo(CONTRACT_CALCULATOR_LINK);
        assertThat(links.get(2).text()).isEqualTo(CONTRACT_CALCULATOR_TEXT);
    }
}
