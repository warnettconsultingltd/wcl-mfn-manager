package org.wcl.mfn.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("#{'${url.home}'}")
    public String homePage(Model model,
                           @Value("${common.view.attribute.page-title}") String pageTitleAttribute,
                           @Value("${page.home.title}") String title,
                           @Value("${view.home}") String viewName){

        model.addAttribute(pageTitleAttribute, title);

        return viewName;
    }

}
