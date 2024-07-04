package org.wcl.mfn.ui.integration.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.wcl.mfn.ui.controller.HomeController;
import org.wcl.mfn.ui.utilities.NavigationBarChecker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = HomeController.class)
@ContextConfiguration(classes = HomeController.class)
@ImportAutoConfiguration(ThymeleafAutoConfiguration.class)
public class HomePageTest {
    @Value("${url.home}")
    private String url;

    @Value("${view.home}")
    private String viewName;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenServerRunning_whenHomeURLInvoked_thenHomePageRendered() throws Exception {
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name(viewName));
    }

    @Test
    public void givenServerRunning_whenHomePageDisplayed_thenNavigationBarExists() throws Exception {
        final var mvcResult = mockMvc.perform(get(url)).andReturn();

        NavigationBarChecker.checkNavigationBarContents(mvcResult.getResponse().getContentAsString());
    }
}

