package org.wcl.mfn.ui.integration.controller.tools

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.wcl.mfn.config.ui.common.PageTitleConfig
import org.wcl.mfn.config.ui.mvc.*
import org.wcl.mfn.config.ui.tools.*
import org.wcl.mfn.config.url.UrlConfig
import org.wcl.mfn.ui.controller.tools.ContractCalculatorUIController
import org.wcl.mfn.ui.utilities.NavigationBarChecker

@WebMvcTest(ContractCalculatorUIController::class)
@ContextConfiguration(classes = [ContractCalculatorUIController::class, ContractCalculatorConfig::class, ContractCalculatorMessagesConfig::class, PageTitleConfig::class, ModelConfig::class, ViewConfig::class, UrlConfig::class])
class ContractCalculatorUIControllerPageTest {
    @Autowired
    private val urlConfig: UrlConfig? = null

    @Autowired
    private val viewConfig: ViewConfig? = null

    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    @Throws(Exception::class)
    fun givenServerRunning_whenContractCalculatorURLInvoked_thenContractControllerPageToBeRendered() {
        urlConfig!!.contractCalculatorUrl()?.let { MockMvcRequestBuilders.get(it) }?.let {
            viewConfig!!.contractCalculatorView()?.let { it1 -> MockMvcResultMatchers.view().name(it1) }?.let { it2 ->
                mockMvc!!.perform(it)
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(it2)
            }
        }
    }

    @Test
    @Throws(Exception::class)
    fun givenServerRunning_whenHomePageDisplayed_thenNavigationBarExists() {
        val mvcResult =
            urlConfig!!.contractCalculatorUrl()?.let { MockMvcRequestBuilders.get(it) }
                ?.let { mockMvc!!.perform(it).andReturn() }

        if (mvcResult != null) {
            NavigationBarChecker.checkNavigationBarContents(mvcResult.response.contentAsString)
        }
    }
}

