package org.wcl.mfn.ui.utilities;

import static org.assertj.core.api.Assertions.*;
import org.jsoup.Jsoup;

public class NavigationBarChecker {
    private static final String HREF_ATTRIBUTE = "href";
    private static final String A_ATTRIBUTE = "a";

    private static final String HOME_TEXT = "Home";
    private static final String HOME_LINK = "/";

    private static final String CONTRACT_CALCULATOR_TEXT = "Contract Calculator";
    private static final String CONTRACT_CALCULATOR_LINK = "/contract-calculator";

    private static final String TOOLS_MENU_TEXT = "Tools";

    private static final int HOME_LINK_INDEX = 0;
    private static final int TOOLS_MENU_INDEX = 1;
    public static final int CONTRACT_CALCULATOR_INDEX = 2;

    private NavigationBarChecker() {}

    public static void checkNavigationBarContents(String htmlContent) {
        final var links = Jsoup.parse(htmlContent).select(A_ATTRIBUTE);

        assertThat(links.size()).isEqualTo(3);
        assertThat(links.get(HOME_LINK_INDEX).attr(HREF_ATTRIBUTE)).isEqualTo(HOME_LINK);
        assertThat(links.get(HOME_LINK_INDEX).text()).isEqualTo(HOME_TEXT);
        assertThat(links.get(TOOLS_MENU_INDEX).text()).isEqualTo(TOOLS_MENU_TEXT);
        assertThat(links.get(CONTRACT_CALCULATOR_INDEX).attr(HREF_ATTRIBUTE)).isEqualTo(CONTRACT_CALCULATOR_LINK);
        assertThat(links.get(CONTRACT_CALCULATOR_INDEX).text()).isEqualTo(CONTRACT_CALCULATOR_TEXT);
    }
}
