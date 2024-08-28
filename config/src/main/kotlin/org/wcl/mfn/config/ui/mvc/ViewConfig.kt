package org.wcl.mfn.config.ui.mvc

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:ui/mvc/view.properties")
open class ViewConfig {
    @Value("\${view.home}")
    private val homeView: String? = null

    @Value("\${view.tools.contract-calculator}")
    private val contractCalculatorView: String? = null

    fun homeView(): String? {
        return homeView
    }

    fun contractCalculatorView(): String? {
        return contractCalculatorView
    }
}
