package org.wcl.mfn.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Value("${page.home.title}")
    private String title;
    private static final String HOME_PAGE = "pages/home/home";
    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("page_title", title);
        return HOME_PAGE;
    }


}
