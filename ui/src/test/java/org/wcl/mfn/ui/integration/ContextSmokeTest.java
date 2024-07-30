package org.wcl.mfn.ui.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.wcl.mfn.ui.controller.HomeController;
import org.wcl.mfn.ui.controller.tools.ContractCalculatorController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes=TestConfig.class)
@ContextConfiguration(classes = {HomeController.class, ContractCalculatorController.class})
public class ContextSmokeTest {
    @Autowired
    private HomeController homePageController;

    @Autowired
    private ContractCalculatorController contractCalculatorController;

    @Test
    void contextLoads() {
        assertThat(homePageController).isNotNull();
        assertThat(contractCalculatorController).isNotNull();
    }
}
