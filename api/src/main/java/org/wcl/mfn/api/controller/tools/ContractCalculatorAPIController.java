package org.wcl.mfn.api.controller.tools;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.wcl.mfn.entities.contract.calculator.*;
import org.wcl.mfn.exceptions.InvalidParameterException;
import org.wcl.mfn.service.tools.ContractCalculatorService;

import java.util.List;

@RestController
public class ContractCalculatorAPIController {
    private final ContractCalculatorService service;

    public ContractCalculatorAPIController(@Autowired final ContractCalculatorService service) {
        this.service = service;
    }

    @PostMapping(value = "/api/contract-calculator",
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SuggestedContract>> calculateSuggestedContracts (
            @RequestBody @NotNull RequestedRemuneration requestedRemuneration) throws InvalidParameterException {
        if (requestedRemuneration.salary() == 0 || requestedRemuneration.bonus() == 0) {
            throw new InvalidParameterException("MFN-CONTRACT-001 : Salary and Bonus must be positive, non-zero values");
        }

        return ResponseEntity.ok(service.suggestedContracts(requestedRemuneration.salary(),
                requestedRemuneration.bonus()));
    }
}
