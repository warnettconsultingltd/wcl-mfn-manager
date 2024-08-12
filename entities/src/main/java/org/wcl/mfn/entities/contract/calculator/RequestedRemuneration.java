package org.wcl.mfn.entities.contract.calculator;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public record RequestedRemuneration(
        @Schema(
                name = "salary",
                description = "The requested salary",
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        @JsonProperty("salary") Integer salary,
        @Schema(
                name = "bonus",
                description = "The requested bonus",
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        @JsonProperty("bonus") Integer bonus) {}

