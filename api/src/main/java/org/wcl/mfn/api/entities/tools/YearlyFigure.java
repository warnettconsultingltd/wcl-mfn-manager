package org.wcl.mfn.api.entities.tools;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record YearlyFigure(
        @Schema(
                name = "year",
                description = "The year of this suggested contract",
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        @JsonProperty("year")
        @Min(1L)
        @Max(6L) Integer year,

        @Schema(
                name = "salary",
                description = "The salary for this year of the suggested contract",
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        @JsonProperty("salary") Integer salary,


        @Schema(
                name = "yearlyRemuneration",
                description = "The yearly remuneration for this year of the suggested contract",
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        @JsonProperty("yearlyRemuneration") Integer yearlyRemuneration){}
