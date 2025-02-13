package org.wcl.mfn.ui.integration.controller.tools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wcl.mfn.api.controller.tools.ContractCalculatorAPIController;
import org.wcl.mfn.config.url.UrlConfig;

import org.wcl.mfn.ui.config.common.PageTitleConfig;
import org.wcl.mfn.ui.config.mvc.*;
import org.wcl.mfn.ui.config.tools.*;
import org.wcl.mfn.ui.controller.tools.ContractCalculatorUIController;
import org.wcl.mfn.ui.utilities.NavigationBarChecker;

import org.wcl.mfn.service.tools.ContractCalculatorService;

@WebMvcTest(ContractCalculatorUIController.class)
@ContextConfiguration(classes = {ContractCalculatorUIController.class, ContractCalculatorService.class, ContractCalculatorAPIController.class, ContractCalculatorConfig.class,
        ContractCalculatorMessagesConfig.class, PageTitleConfig.class, ModelConfig.class, ViewConfig.class, UrlConfig.class})
class ContractCalculatorUIControllerPageTest {
    @Autowired
    private UrlConfig urlConfig;

    @Autowired
    private ViewConfig viewConfig;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenServerRunning_whenContractCalculatorURLInvoked_thenContractControllerPageToBeRendered() throws Exception {
        String contractCalculatorUrl = urlConfig.contractCalculatorUrl();
        if (contractCalculatorUrl != null) {
            String contractCalculatorView = viewConfig.contractCalculatorView();
            if (contractCalculatorView != null) {
                mockMvc.perform(MockMvcRequestBuilders.get(contractCalculatorUrl))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.view().name(contractCalculatorView));
            }
        }
    }

    @Test
    void givenServerRunning_whenHomePageDisplayed_thenNavigationBarExists() throws Exception {
        String contractCalculatorUrl = urlConfig.contractCalculatorUrl();
        if (contractCalculatorUrl != null) {
            var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(contractCalculatorUrl)).andReturn();
            NavigationBarChecker.checkNavigationBarContents(mvcResult.getResponse().getContentAsString());
        }
    }
}

