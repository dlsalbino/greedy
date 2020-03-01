package br.com.azusah.greedy.framework.controllers.resources.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.26
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocationRequest {

    @Schema(description = "The country's name.",
            example = "Brazil",
            required = true
    )
    @NotBlank
    private String country;

    @Schema(description = "The state's abbreviation",
            example = "SP",
            required = true
    )
    @NotBlank
    @Size(min = 2, max = 2)
    private String state;

    @Schema(description = "The city's name.",
            example = "Santo André",
            required = true
    )
    @NotBlank
    private String city;

    @Schema(description = "The neighborhood's name.",
            example = "Bairro Jardim",
            required = true
    )
    @NotBlank
    private String neighborhood;

    @Schema(description = "The name of the street or avenue.",
            example = "Rua das Figueiras",
            required = true
    )
    @NotBlank
    private String address;

    @Schema(description = "The number where the place is on the street, avenue, etc.",
            example = "1274",
            required = true
    )
    @NotBlank
    private String number;

    @Schema(description = "The complement of the address.",
            example = "10th Floor",
            required = false
    )
    private String complement;

    @Schema(description = "The zipcode of the address.",
            example = "09070561",
            required = true
    )
    @NotBlank
    private String zipCode;
}
