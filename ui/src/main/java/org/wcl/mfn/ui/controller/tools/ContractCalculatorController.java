package org.wcl.mfn.ui.controller.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wcl.mfn.ui.model.SuggestedYearContract;

import java.util.List;

@Controller
public class ContractCalculatorController {
    @Value("${page.contract-calculator.title}")
    private String title;

    private static final String CONTRACT_CALCULATOR_PAGE = "pages/tools/contract-calculator";

    @GetMapping("/contract-calculator")
    public String contractCalculatorPage(Model model) {
        model.addAttribute("page_title", title);
        model.addAttribute("suggestedContracts",generateBlankContracts());

        return CONTRACT_CALCULATOR_PAGE;
    }

    private List<SuggestedYearContract> generateBlankContracts() {
       return List.of(new SuggestedYearContract(2,0,0,
                            List.of(0,0),0,0),
                      new SuggestedYearContract(3,0,0,
                            List.of(0,0, 0),0,0),
                      new SuggestedYearContract(4,0,0,
                            List.of(0,0, 0, 0),0,0),
                      new SuggestedYearContract(5,0,0,
                            List.of(0,0, 0, 0, 0),0,0),
                      new SuggestedYearContract(6,0,0,
                            List.of(0,0, 0, 0, 0, 0),0,0));
    }
}


