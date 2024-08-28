package org.wcl.mfn.config.ui.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.*

@Configuration
@PropertySource("classpath:ui/common/page-title.properties")
open class PageTitleConfig {
    @Value("\${page.home.title}")
    private val homePageTitle: String? = null

    @Value("\${page.contract-calculator.title}")
    private val contractCalculatorPageTitle: String? = null

    fun homePageTitle(): String? {
        return homePageTitle
    }

    fun contractCalculatorPageTitle(): String? {
        return contractCalculatorPageTitle
    }
}
