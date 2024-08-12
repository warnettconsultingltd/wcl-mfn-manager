package org.wcl.mfn.api.entities.tools;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SuggestedContract(
    @Schema(
            name = "years",
            description = "The number of years of the suggested contract.",
            requiredMode = RequiredMode.NOT_REQUIRED
    )
    @JsonProperty("years") Integer years,

    @Schema(
            name = "totalSalary",
            description = "The total salary for this suggested contract.",
            requiredMode = RequiredMode.NOT_REQUIRED
    )
    @JsonProperty("totalSalary") Integer totalSalary,

    @Schema(
            name = "bonusPerYear",
            description = "The bonus per year for this suggested contract.",
            requiredMode = RequiredMode.NOT_REQUIRED
    )
    @JsonProperty("bonusPerYear") Integer bonusPerYear,

    @Schema(
            name = "totalRemuneration",
            description = "The total remuneration over this suggested contract, salary and bonus combined.",
            requiredMode = RequiredMode.NOT_REQUIRED
    )
    @JsonProperty("totalRemuneration") Integer totalRemuneration,

    @Schema(
            name = "yearlyFigures",
            requiredMode = RequiredMode.NOT_REQUIRED
    )
    @JsonProperty("yearlyFigures")
    @Size(
            min = 2,
            max = 6
    )
    @Valid List<YearlyFigure> yearlyFigures){}

