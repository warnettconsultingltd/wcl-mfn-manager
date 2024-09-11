package org.wcl.mfn.ui.controller.tools

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.wcl.mfn.config.ui.common.PageTitleConfig
import org.wcl.mfn.config.ui.mvc.*
import org.wcl.mfn.config.ui.tools.*
import org.wcl.mfn.ui.model.tools.contractcalculator.SuggestedYearContract

@Controller
@PropertySource("classpath:/url/url.properties")
class ContractCalculatorController {
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

    @GetMapping("#{'\${url.tools.contract-calculator}'}")
    fun contractCalculatorPage(model: Model): String? {
        modelConfig!!.pageTitle()?.let { model.addAttribute(it, pageTitleConfig!!.contractCalculatorPageTitle()) }
        contractCalculatorConfig!!.contractParameters()
            ?.let { model.addAttribute(it, generateBlankContractParameters()) }
        model.addAttribute("contract_parameter_elements", generateContractCalculatorUIElements())
        contractCalculatorConfig.suggestedContracts()?.let { model.addAttribute(it, generateBlankContracts()) }

        return viewConfig!!.contractCalculatorView()
    }

    private fun generateBlankContracts(): List<SuggestedYearContract> {
        return java.util.List.of(
            SuggestedYearContract(
                2, 0, 0,
                listOf(0, 0), 0,
                listOf(0, 0)
            ),
            SuggestedYearContract(
                3, 0, 0,
                listOf(0, 0, 0), 0,
                listOf(0, 0, 0)
            ),
            SuggestedYearContract(
                4, 0, 0,
                listOf(0, 0, 0, 0), 0,
                listOf(0, 0, 0, 0)
            ),
            SuggestedYearContract(
                5, 0, 0,
                listOf(0, 0, 0, 0, 0), 0,
                listOf(0, 0, 0, 0, 0)
            ),
            SuggestedYearContract(
                6, 0, 0,
                listOf(0, 0, 0, 0, 0, 0), 0,
                listOf(0, 0, 0, 0, 0, 0)
            )
        )
    }


    private fun generateBlankContractParameters(): ContractParameters {
        return ContractParameters(0, 0)
    }

    private fun generateContractCalculatorUIElements(): ContractCalculatorUIElements {
        return ContractCalculatorUIElements(
            contractCalculatorMessagesConfig!!.minSalary(),
            contractCalculatorMessagesConfig.bonus(),
            Escalator(
                contractCalculatorMessagesConfig.escalator(),
                contractCalculatorConfig!!.escalatorDefault(),
                contractCalculatorConfig.escalatorMax(),
                contractCalculatorConfig.escalatorStep()
            ),
            contractCalculatorMessagesConfig.reset(),
            contractCalculatorMessagesConfig.submit()
        )
    }

  //  @JvmRecord
    internal data class ContractParameters(val salary: Int, val bonus: Int, val escalator: Int) {
        constructor(salary: Int, bonus: Int) : this(salary, bonus, DEFAULT_ESCALATOR)

        companion object {
            private const val DEFAULT_ESCALATOR = 5
        }
    }

   // @JvmRecord
    internal data class Escalator(val label: String?, val defaultValue: Int, val max: Int, val step: Int)

  //  @JvmRecord
    internal data class ContractCalculatorUIElements(
        val minSalary: String?,
        val bonus: String?,
        val escalator: Escalator,
        val reset: String?,
        val submit: String?
    )
}


