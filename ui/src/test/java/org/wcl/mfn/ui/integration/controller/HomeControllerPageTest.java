package org.wcl.mfn.ui.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wcl.mfn.config.url.UrlConfig;
import org.wcl.mfn.ui.config.common.PageTitleConfig;
import org.wcl.mfn.ui.config.mvc.ModelConfig;
import org.wcl.mfn.ui.config.mvc.ViewConfig;
import org.wcl.mfn.ui.controller.HomeController;
import org.wcl.mfn.ui.utilities.NavigationBarChecker;

@WebMvcTest(HomeController.class)
@ContextConfiguration(classes = {HomeController.class, PageTitleConfig.class, ModelConfig.class,
        ViewConfig.class, UrlConfig.class})
public class HomeControllerPageTest {
    @Autowired
    private UrlConfig urlConfig;

    @Autowired
    private ViewConfig viewConfig;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenServerRunning_whenHomeURLInvoked_thenHomePageRendered() throws Exception {
        String homeUrl = urlConfig.homeUrl();
            String homeView = viewConfig.homeView();

                mockMvc.perform(MockMvcRequestBuilders.get(homeUrl))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.view().name(homeView));
    }

    @Test
    public void givenServerRunning_whenHomePageDisplayed_thenNavigationBarExists() throws Exception {
        String homeUrl = urlConfig.homeUrl();

            var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(homeUrl)).andReturn();
            NavigationBarChecker.checkNavigationBarContents(mvcResult.getResponse().getContentAsString());
    }
}

