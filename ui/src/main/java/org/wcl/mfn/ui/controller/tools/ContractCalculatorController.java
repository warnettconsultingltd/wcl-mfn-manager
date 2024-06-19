package org.wcl.mfn.ui.controller.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractCalculatorController {
    @Value("${page.contract-calculator.title}")
    private String title;

    private static final String CONTRACT_CALCULATOR_PAGE = "pages/tools/contract-calculator";

    @GetMapping("/contract_calculator")
    public String contractCalculatorPage(Model model) {
        model.addAttribute("page_title", title);
        return CONTRACT_CALCULATOR_PAGE;
    }
}
