package org.wcl.mfn.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wcl.mfn.ui.config.mvc.ViewConfig;

@Controller
public class HomeController {
    private final ViewConfig viewConfig;

    private HomeController(@Autowired ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("page_title", "MFN Manager - Home");

        return viewConfig.homeView();
    }
}
