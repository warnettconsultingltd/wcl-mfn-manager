package org.wcl.mfn.service.tools

import org.springframework.stereotype.Service
import org.wcl.mfn.entities.contract.calculator.SuggestedContract
import org.wcl.mfn.exceptions.validation.InvalidParameterException

@Service
class ContractCalculatorService {
    fun suggestedContracts(requestedSalary: Int, requestedBonus: Int): List<SuggestedContract> {
        if (requestedSalary <= 0) {
            throw InvalidParameterException("Invalid requested salary - cannot be negative or zero");
        }
        if (requestedBonus <= 0) {
            throw InvalidParameterException("Invalid requested bonus - cannot be negative or zero");
        }
        return ArrayList()
    }
}
