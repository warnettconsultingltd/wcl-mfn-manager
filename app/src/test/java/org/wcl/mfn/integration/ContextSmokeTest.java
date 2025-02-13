package org.wcl.mfn.integration;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.wcl.mfn.api.controller.tools.ContractCalculatorAPIController;
import org.wcl.mfn.ui.config.common.PageTitleConfig;
import org.wcl.mfn.ui.config.mvc.ModelConfig;
import org.wcl.mfn.ui.config.mvc.ViewConfig;
import org.wcl.mfn.ui.config.tools.ContractCalculatorConfig;
import org.wcl.mfn.ui.config.tools.ContractCalculatorMessagesConfig;
import org.wcl.mfn.ui.controller.HomeController;
import org.wcl.mfn.ui.controller.tools.ContractCalculatorUIController;

@SpringBootTest()
@ComponentScan(basePackages = "org.wcl.mfn")
class ContextSmokeTest {
    @Autowired
    private HomeController homePageController;

    @Autowired
    private ContractCalculatorUIController contractCalculatorController;

    @Test
    void checkThatContextLoads() {
        assertThat(homePageController).isNotNull();
        assertThat(contractCalculatorController).isNotNull();
    }
}
