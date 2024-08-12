package org.wcl.mfn.api.controller.tools;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wcl.mfn.api.entities.tools.*;

import java.util.*;

@RestController
public class ContractCalculatorController implements ContractCalculatorApi {

    @Override
    public ResponseEntity<List<SuggestedContract>> contractCalculatorPost(
            @Valid @RequestBody RequestedRemuneration requestedRemuneration) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
