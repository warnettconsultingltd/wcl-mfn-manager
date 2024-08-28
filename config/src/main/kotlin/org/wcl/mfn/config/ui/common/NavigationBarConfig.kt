package org.wcl.mfn.config.ui.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.*

@Configuration
@PropertySource("classpath:ui/common/navigation-bar.properties")
open class NavigationBarConfig {
    @Value("\${mfn.navbar}")
    private val navigationBarId: String? = null

    @Value("\${mfn.navbar.home}")
    private val navigationBarHomeId: String? = null

    @Value("\${mfn.navbar.tools}")
    private val navigationBarToolsId: String? = null

    @Value("\${mfn.navbar.contract-calculator}")
    private val navigationBarContractCalculatorId: String? = null

    fun navigationBarId(): String? {
        return navigationBarId
    }

    fun navigationBarHomeId(): String? {
        return navigationBarHomeId
    }

    fun navigationBarToolsId(): String? {
        return navigationBarToolsId
    }

    fun navigationBarContractCalculatorId(): String? {
        return navigationBarContractCalculatorId
    }
}
