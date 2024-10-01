package org.wcl.mfn.ui.controller.tools

import jakarta.validation.Valid
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.client.RestTemplate
import org.wcl.mfn.api.controller.tools.ContractCalculatorAPIController
import org.wcl.mfn.config.ui.common.PageTitleConfig
import org.wcl.mfn.config.ui.mvc.*
import org.wcl.mfn.config.ui.tools.*
import org.wcl.mfn.entities.contract.calculator.RequestedRemuneration
import org.wcl.mfn.entities.contract.calculator.SuggestedContract
import org.wcl.mfn.entities.contract.calculator.SuggestedYearlyContract
import org.wcl.mfn.ui.controller.forms.contractcalculator.RequestedRemunerationForm
import org.wcl.mfn.ui.controller.forms.contractcalculator.SalaryEscalatorForm
import java.net.URI


@Controller
@PropertySource("classpath:/url/url.properties")
class ContractCalculatorUIController {
    @Autowired
    private val pageTitleConfig: PageTitleConfig? = null

    @Autowired
    private val viewConfig: ViewConfig? = null

    @Autowired
    private val modelConfig: ModelConfig? = null

    @Autowired
    private val contractCalculatorConfig: ContractCalculatorConfig? = null

    @Autowired
    private val contractCalculatorMessagesConfig: ContractCalculatorMessagesConfig? = null

    @Autowired
    private val apiController: ContractCalculatorAPIController? = null

    private var requestedRemuneration = RequestedRemunerationForm(0,0, SalaryEscalatorForm(5))

    @GetMapping("/contract-calculator")
    fun contractCalculatorPage(model: Model): String {
        model.addAttribute("page_title",pageTitleConfig!!.contractCalculatorPageTitle())
        model.addAttribute("requested_remuneration", requestedRemuneration)
        model.addAttribute("suggested_contracts", generateBlankContracts())

        return "pages/tools/contract-calculator"
    }

    @PostMapping("/contract-calculator/submit")
    fun updateSuggestedContracts(@ModelAttribute("requested_remuneration") contractDemands:RequestedRemunerationForm, model:Model): String? {
        requestedRemuneration = contractDemands;

        model.addAttribute("page_title",pageTitleConfig!!.contractCalculatorPageTitle())
        model.addAttribute("requested_remuneration", requestedRemuneration)
        model.addAttribute("suggested_contracts", getSuggestedContracts())

        return "pages/tools/contract-calculator"
    }

    private fun getSuggestedContracts() : List<SuggestedContract> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.accept = listOf(MediaType.APPLICATION_JSON)

        val entity: HttpEntity<RequestedRemuneration> = HttpEntity(RequestedRemuneration(
            requestedRemuneration.salary,
            requestedRemuneration.bonus), headers)

        val restTemplate = RestTemplate()

        val response: ResponseEntity<List<SuggestedContract>> = restTemplate.exchange(
            URI.create("http://localhost:8080/api/contract-calculator"),
            HttpMethod.POST,
            entity,
            typeReference<List<SuggestedContract>>())
        return response.body
    }

    private fun generateBlankContracts(): List<SuggestedContract> {
        return listOf(SuggestedContract(
            2,0,0,0,
            listOf(SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0))
            ),
            SuggestedContract(
                3,0,0,0,
                listOf(SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0))
            ),
            SuggestedContract(
                4,0,0,0,
                listOf(SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0))
            ),
            SuggestedContract(
                5,0,0,0,
                listOf(SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0))
            ),
            SuggestedContract(
                6,0,0,0,
                listOf(SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0),
                    SuggestedYearlyContract(0,0,0))
            )
        )
    }
//
//    internal data class ContractParameters(val salary: Int, val bonus: Int, val escalator: Int) {
//        constructor(salary: Int, bonus: Int) : this(salary, bonus, DEFAULT_ESCALATOR)
//
//        companion object {
//            private const val DEFAULT_ESCALATOR = 5
//        }
//    }

//    internal data class Escalator(val label: String?, val defaultValue: Int, val max: Int, val step: Int)

    private inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}
}


