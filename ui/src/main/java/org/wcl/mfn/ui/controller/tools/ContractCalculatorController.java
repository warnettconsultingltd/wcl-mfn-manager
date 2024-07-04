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

    @Value("${view.tools.contract-calculator}")
    private String viewName;

    @GetMapping("#{'${url.tools.contract-calculator}'}")
    public String contractCalculatorPage(Model model,
                                         @Value("${common.view.attribute.page-title}") String pageTitle,
                                         @Value("${contract-calculator.view.attribute.contract-parameters}") String contractParameters,
                                         @Value("${contract-calculator.view.attribute.suggested-contracts}") String suggestedContracts) {
        model.addAttribute(pageTitle, title);
        model.addAttribute(contractParameters, generateBlankContractParameters());
        model.addAttribute(suggestedContracts,generateBlankContracts());

        return viewName;
    }

    private List<SuggestedYearContract> generateBlankContracts() {
       return List.of(new SuggestedYearContract(2,0,0,
                            List.of(0,0),0,
                            List.of(0,0)),
                      new SuggestedYearContract(3,0,0,
                            List.of(0,0, 0),0,
                              List.of(0,0,0)),
                      new SuggestedYearContract(4,0,0,
                            List.of(0,0, 0, 0),0,
                              List.of(0,0,0,0)),
                      new SuggestedYearContract(5,0,0,
                            List.of(0,0, 0, 0, 0),0,
                              List.of(0,0,0,0,0)),
                      new SuggestedYearContract(6,0,0,
                            List.of(0,0, 0, 0, 0, 0),0,
                              List.of(0,0,0,0,0,0)));
    }

    private ContractParameters generateBlankContractParameters() {
        return new ContractParameters(0,0);
    }

    record ContractParameters(int salary, int bonus, int escalator) {
        private static final int DEFAULT_ESCALATOR = 5;

        public ContractParameters(int salary, int bonus) {
            this(salary, bonus, DEFAULT_ESCALATOR);
        }
    }
}


