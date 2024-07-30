package org.wcl.mfn.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wcl.mfn.config.ui.common.PageTitleConfig;
import org.wcl.mfn.config.ui.mvc.*;

@Controller
@PropertySource("classpath:/url/url.properties")
public class HomeController {
    @Autowired
    private PageTitleConfig pageTitleConfig;

    @Autowired
    private ModelConfig modelConfig;

    @Autowired
    private ViewConfig viewConfig;

    @GetMapping("#{'${url.home}'}")
    public String homePage(Model model) {
        model.addAttribute(modelConfig.pageTitle(), pageTitleConfig.homePageTitle());

        return viewConfig.contractCalculatorView();
    }

}
