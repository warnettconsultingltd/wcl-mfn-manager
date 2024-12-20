package org.wcl.mfn.integration;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.wcl.mfn.ui.controller.HomeController;
import org.wcl.mfn.ui.controller.tools.ContractCalculatorUIController;

@SpringBootTest()
@ContextConfiguration(classes = {HomeController.class, ContractCalculatorUIController.class})
public class ContextSmokeTest {
    @Autowired
    private HomeController homePageController;

    @Autowired
    private ContractCalculatorUIController contractCalculatorController;

    @Test
    public void checkThatContextLoads() {
        assertThat(homePageController).isNotNull();
        assertThat(contractCalculatorController).isNotNull();
    }
}
