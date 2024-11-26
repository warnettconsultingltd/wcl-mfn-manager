package org.wcl.mfn.config.url

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.*

@Configuration
@PropertySource("classpath:url/url.properties")
open class UrlConfig {
    @Value("\${url.home}")
    private val homeUrl: String? = null

    @Value("\${url.tools.contract-calculator}")
    private val contractCalculatorUrl: String? = null

    fun homeUrl(): String? {
        return homeUrl
    }

    fun contractCalculatorUrl(): String? {
        return contractCalculatorUrl
    }
}
