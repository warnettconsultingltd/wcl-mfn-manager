package org.wcl.mfn.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Value("${page.home.title}")
    private String title;

    @Value("${view.home}")
    private String viewName;

    @GetMapping("#{'${url.home}'}")
    public String homePage(Model model, @Value("common.view.attribute.page-title") String pageTitle) {
        model.addAttribute(pageTitle, title);
        return viewName;
    }

}
