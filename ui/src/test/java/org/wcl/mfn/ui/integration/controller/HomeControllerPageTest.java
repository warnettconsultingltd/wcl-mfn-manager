package org.wcl.mfn.ui.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.wcl.mfn.config.ui.common.PageTitleConfig;
import org.wcl.mfn.config.ui.mvc.*;
import org.wcl.mfn.config.url.UrlConfig;
import org.wcl.mfn.ui.controller.HomeController;
import org.wcl.mfn.ui.utilities.NavigationBarChecker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
@ContextConfiguration(classes = {HomeController.class, PageTitleConfig.class, ModelConfig.class, ViewConfig.class,UrlConfig.class})
public class HomeControllerPageTest {
    @Autowired
    private UrlConfig urlConfig;

    @Autowired
    private ViewConfig viewConfig;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenServerRunning_whenHomeURLInvoked_thenHomePageRendered() throws Exception {
        mockMvc.perform(get(urlConfig.homeUrl()))
                .andExpect(status().isOk())
                .andExpect(view().name(viewConfig.homeView()));
    }

    @Test
    public void givenServerRunning_whenHomePageDisplayed_thenNavigationBarExists() throws Exception {
        final var mvcResult = mockMvc.perform(get(urlConfig.homeUrl())).andReturn();

        NavigationBarChecker.checkNavigationBarContents(mvcResult.getResponse().getContentAsString());
    }
}

