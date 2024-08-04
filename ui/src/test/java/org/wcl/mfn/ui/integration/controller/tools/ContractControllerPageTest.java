package org.wcl.mfn.ui.integration.controller.tools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.wcl.mfn.config.ui.common.PageTitleConfig;
import org.wcl.mfn.config.ui.mvc.*;
import org.wcl.mfn.config.ui.tools.ContractCalculatorConfig;
import org.wcl.mfn.config.ui.tools.ContractCalculatorMessagesConfig;
import org.wcl.mfn.config.url.UrlConfig;
import org.wcl.mfn.ui.controller.tools.ContractCalculatorController;
import org.wcl.mfn.ui.utilities.NavigationBarChecker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContractCalculatorController.class)
@ContextConfiguration(classes = {ContractCalculatorController.class, ContractCalculatorConfig.class, ContractCalculatorMessagesConfig.class, PageTitleConfig.class, ModelConfig.class, ViewConfig.class, UrlConfig.class})
public class ContractControllerPageTest {
    @Autowired
    private UrlConfig urlConfig;

    @Autowired
    private ViewConfig viewConfig;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenServerRunning_whenContractCalculatorURLInvoked_thenHomePageRendered() throws Exception {
        mockMvc.perform(get(urlConfig.contractCalculatorUrl()))
                .andExpect(status().isOk())
                .andExpect(view().name(viewConfig.contractCalculatorView()));
    }

    @Test
    public void givenServerRunning_whenHomePageDisplayed_thenNavigationBarExists() throws Exception {
        final var mvcResult = mockMvc.perform(get(urlConfig.contractCalculatorUrl())).andReturn();

        NavigationBarChecker.checkNavigationBarContents(mvcResult.getResponse().getContentAsString());
    }
}

