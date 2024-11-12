package org.wcl.mfn.entities.contract.calculator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RequestedRemuneration(@JsonProperty("salary") int salary, @JsonProperty("bonus")  int bonus) {
}
