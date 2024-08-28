package org.wcl.mfn.config.ui.mvc

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.*

@Configuration
@PropertySource("classpath:ui/mvc/model.properties")
open class ModelConfig {
    @Value("\${common.view.attribute.page-title}")
    private val pageTitle: String? = null

    fun pageTitle(): String? {
        return pageTitle
    }
}
