package org.wcl.mfn.ui.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.wcl.mfn.config.ui.common.PageTitleConfig
import org.wcl.mfn.config.ui.mvc.*

@Controller
@PropertySource("classpath:/url/url.properties")
class HomeController {
    @Autowired
    private val pageTitleConfig: PageTitleConfig? = null

    @Autowired
    private val modelConfig: ModelConfig? = null

    @Autowired
    private val viewConfig: ViewConfig? = null

    @GetMapping("#{'\${url.home}'}")
    fun homePage(model: Model): String? {
        modelConfig!!.pageTitle()?.let { model.addAttribute(it, pageTitleConfig!!.homePageTitle()) }

        return viewConfig!!.homeView()
    }
}
