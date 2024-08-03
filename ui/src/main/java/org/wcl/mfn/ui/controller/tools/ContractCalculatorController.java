package org.wcl.mfn.ui.controller.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wcl.mfn.config.ui.common.PageTitleConfig;
import org.wcl.mfn.config.ui.mvc.ModelConfig;
import org.wcl.mfn.config.ui.mvc.ViewConfig;
import org.wcl.mfn.config.ui.tools.ContractCalculatorConfig;
import org.wcl.mfn.config.ui.tools.ContractCalculatorMessagesConfig;
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
    @Autowired
    private ContractCalculatorMessagesConfig contractCalculatorMessagesConfig;

    @GetMapping("#{'${url.tools.contract-calculator}'}")
    public String contractCalculatorPage(Model model) {
        model.addAttribute(modelConfig.pageTitle(), pageTitleConfig.contractCalculatorPageTitle());
        model.addAttribute(contractCalculatorConfig.contractParameters(), generateBlankContractParameters());
        model.addAttribute("contract_parameter_elements", generateContractCalculatorUIElements());
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

    private ContractCalculatorUIElements generateContractCalculatorUIElements() {
        return new ContractCalculatorUIElements(contractCalculatorMessagesConfig.minSalary(),
                                                contractCalculatorMessagesConfig.bonus(),
                new Escalator(contractCalculatorMessagesConfig.escalator(),
                                contractCalculatorConfig.escalatorDefault(),
                        contractCalculatorConfig.escalatorMax(),
                        contractCalculatorConfig.escalatorStep()
//                        ccc.

                        ),
        contractCalculatorMessagesConfig.reset(),
                contractCalculatorMessagesConfig.submit());
    }

    record ContractParameters(int salary, int bonus, int escalator) {
        private static final int DEFAULT_ESCALATOR = 5;

        public ContractParameters(int salary, int bonus) {
            this(salary, bonus, DEFAULT_ESCALATOR);
        }
    }

    record Escalator(String label, int defaultValue, int max, int step) {}

    record ContractCalculatorUIElements(String minSalary, String bonus, Escalator escalator, String reset, String submit) {
    }
}


