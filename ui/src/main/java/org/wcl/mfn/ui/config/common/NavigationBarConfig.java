package org.wcl.mfn.ui.config.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:ui/common/navigation-bar.properties")
public class NavigationBarConfig {
    @Value("${mfn.navbar}")
    private String navigationBarId;

    @Value("${mfn.navbar.home}")
    private String navigationBarHomeId;

    @Value("${mfn.navbar.tools}")
    private String navigationBarToolsId;

    @Value("${mfn.navbar.contract-calculator}")
    private String navigationBarContractCalculatorId;

    public String navigationBarId() {
        return navigationBarId;
    }

    public String navigationBarHomeId() {
        return navigationBarHomeId;
    }

    public String navigationBarToolsId() {
        return navigationBarToolsId;
    }

    public String navigationBarContractCalculatorId() {
        return navigationBarContractCalculatorId;
    }
}
