package org.wcl.mfn.api.controller.tools

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.wcl.mfn.entities.contract.calculator.*
import org.wcl.mfn.service.tools.ContractCalculatorService

@RestController
class ContractCalculatorAPIController internal constructor(@param:Autowired private val service: ContractCalculatorService) {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/contract-calculator"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun contractCalculatorPost(@RequestBody requestedRemuneration: @Valid RequestedRemuneration): ResponseEntity<List<SuggestedContract>> {
        return ResponseEntity.ok(
            service.suggestedContracts(
                requestedRemuneration.salary,
                requestedRemuneration.bonus
            )
        )
    }
}
