package org.wcl.mfn.service.tools;

import org.springframework.stereotype.Service;
import org.wcl.mfn.entities.contract.calculator.SuggestedContract;

import java.util.*;

@Service
public class ContractCalculatorService {
    public List<SuggestedContract> suggestedContracts(final int requestedSalary, final int requestedBonus) {
        return new ArrayList<>();
    }
}
