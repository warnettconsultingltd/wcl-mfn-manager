package org.wcl.mfn.ui.integration

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.wcl.mfn.ui.controller.HomeController
import org.wcl.mfn.ui.controller.tools.ContractCalculatorController

@SpringBootTest()
@ContextConfiguration(classes = [HomeController::class, ContractCalculatorController::class])
class ContextSmokeTest {
    @Autowired
    private val homePageController: HomeController? = null

    @Autowired
    private val contractCalculatorController: ContractCalculatorController? = null

    @Test
    fun contextLoads() {
        assertThat(homePageController).isNotNull()
        assertThat(contractCalculatorController).isNotNull()
    }
}
