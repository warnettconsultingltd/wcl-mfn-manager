package org.wcl.mfn.config.ui.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:ui/common/page-title.properties")
public class PageTitleConfig {
    @Value("${page.home.title}")
    private String homePageTitle;

    @Value("${page.contract-calculator.title}")
    private String contractCalculatorPageTitle;

    public String homePageTitle() {
        return homePageTitle;
    }

    public String contractCalculatorPageTitle() {
        return contractCalculatorPageTitle;
    }
}
