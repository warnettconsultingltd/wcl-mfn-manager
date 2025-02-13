package org.wcl.mfn.ui.controller.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.wcl.mfn.api.controller.tools.ContractCalculatorAPIController;
import org.wcl.mfn.entities.contract.calculator.*;
import org.wcl.mfn.ui.config.common.PageTitleConfig;
import org.wcl.mfn.ui.config.mvc.ModelConfig;
import org.wcl.mfn.ui.config.mvc.ViewConfig;
import org.wcl.mfn.ui.config.tools.ContractCalculatorConfig;
import org.wcl.mfn.ui.config.tools.ContractCalculatorMessagesConfig;
import org.wcl.mfn.ui.controller.forms.contractcalculator.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Controller
@PropertySource("classpath:/url/url.properties")
public class ContractCalculatorUIController {
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

    @Autowired
    private ContractCalculatorAPIController apiController;

    private RequestedRemunerationForm requestedRemuneration = new RequestedRemunerationForm(0,0, new SalaryEscalatorForm(5));

    @GetMapping("/contract-calculator")
    public String contractCalculatorPage(Model model) {
        setModelAttributes(model, generateBlankContracts());

        return "pages/tools/contract-calculator";
    }

    @PostMapping("/contract-calculator/submit")
    public String updateSuggestedContracts(@ModelAttribute("requested_remuneration") RequestedRemunerationForm contractDemands, Model model) {
        requestedRemuneration = contractDemands;

        setModelAttributes(model, getSuggestedContracts());

        return "pages/tools/contract-calculator";
    }

    @GetMapping("/contract-calculator/reset")
    public String resetCalculatorPage(Model model) {
        setModelAttributes(model, generateBlankContracts());

        return "redirect:pages/tools/contract-calculator";
    }

    private void setModelAttributes(Model model, List<SuggestedContract> suggestedContracts) {
        model.addAttribute("page_title", pageTitleConfig.contractCalculatorPageTitle());
        model.addAttribute("requested_remuneration", requestedRemuneration);
        model.addAttribute("suggested_contracts", suggestedContracts);
    }

    private List<SuggestedContract> getSuggestedContracts() {
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

//        final var entity = new HttpEntity(new RequestedRemuneration(
//                requestedRemuneration.salary(),
//                requestedRemuneration.bonus()), headers);
        final var client = WebClient.builder()
                .baseUrl("http://localhost:8080/api/contract-calculator")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        final Mono<List<SuggestedContract>> response = client.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

        return new ArrayList<>(response.block());
    }

    private List<SuggestedContract> generateBlankContracts()  {
        return List.of(new SuggestedContract(
                        2,0,0,0,
                        List.of(new SuggestedYearlyContract(1,0,0),
                                new SuggestedYearlyContract(2,0,0))
                ),
                new SuggestedContract(
                        3,0,0,0,
                        List.of(new SuggestedYearlyContract(1,0,0),
                                new SuggestedYearlyContract(2,0,0),
                                new SuggestedYearlyContract(3,0,0))
                ),
                new SuggestedContract(
                        4,0,0,0,
                        List.of(new SuggestedYearlyContract(1,0,0),
                                new SuggestedYearlyContract(2,0,0),
                                new SuggestedYearlyContract(3,0,0),
                                new SuggestedYearlyContract(4,0,0))
                ),
                new SuggestedContract(
                        5,0,0,0,
                        List.of(new SuggestedYearlyContract(1,0,0),
                                new SuggestedYearlyContract(2,0,0),
                                new SuggestedYearlyContract(3,0,0),
                                new SuggestedYearlyContract(4,0,0),
                                new SuggestedYearlyContract(5,0,0))
                ),
                new SuggestedContract(
                        6,0,0,0,
                        List.of(new SuggestedYearlyContract(1,0,0),
                                new SuggestedYearlyContract(2,0,0),
                                new SuggestedYearlyContract(3,0,0),
                                new SuggestedYearlyContract(4,0,0),
                                new SuggestedYearlyContract(5,0,0),
                                new SuggestedYearlyContract(6,0,0))
                )
        );
    }
}


