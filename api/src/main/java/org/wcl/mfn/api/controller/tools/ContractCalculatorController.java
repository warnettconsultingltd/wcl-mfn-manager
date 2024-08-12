package org.wcl.mfn.api.controller.tools;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wcl.mfn.entities.contract.calculator.*;
import org.wcl.mfn.service.tools.ContractCalculatorService;

import java.util.List;

@RestController
public class ContractCalculatorController implements ContractCalculatorApi {
    private ContractCalculatorService service;

    ContractCalculatorController(@Autowired ContractCalculatorService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<SuggestedContract>> contractCalculatorPost(
            @Valid @RequestBody RequestedRemuneration requestedRemuneration) {
        return ResponseEntity.ok(service.suggestedContracts(requestedRemuneration.salary(),
                                                            requestedRemuneration.bonus()));
    }
}
