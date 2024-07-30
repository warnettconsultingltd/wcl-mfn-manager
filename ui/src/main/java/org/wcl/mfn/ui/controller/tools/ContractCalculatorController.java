package org.wcl.mfn.ui.controller.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wcl.mfn.config.ui.common.PageTitleConfig;
import org.wcl.mfn.config.ui.mvc.*;
import org.wcl.mfn.config.ui.tools.ContractCalculatorConfig;
import org.wcl.mfn.ui.model.tools.contractcalculator.SuggestedYearContract;

import java.util.List;

@Controller
@PropertySource("classpath:/url/url.properties")
public class ContractCalculatorController {

    @Autowired
    private PageTitleConfig pageTitleConfig;

    @Autowired
    private ViewConfig viewConfig;

    @Autowired
    private ModelConfig modelConfig;

    @Autowired
    private ContractCalculatorConfig contractCalculatorConfig;

    @GetMapping("#{'${url.tools.contract-calculator}'}")
    public String contractCalculatorPage(Model model) {
        model.addAttribute(modelConfig.pageTitle(), pageTitleConfig.contractCalculatorPageTitle());
        model.addAttribute(contractCalculatorConfig.contractParameters(), generateBlankContractParameters());
        model.addAttribute(contractCalculatorConfig.suggestedContracts(),generateBlankContracts());

        return viewConfig.contractCalculatorView();
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


