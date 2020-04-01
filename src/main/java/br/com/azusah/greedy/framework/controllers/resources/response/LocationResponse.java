package br.com.azusah.greedy.framework.controllers.resources.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocationResponse {

    @Schema(description = "The country's name.",
        example = "Brazil",
        required = true
    )
    private String country;

    @Schema(description = "The state's abbreviation",
        example = "SP",
        required = true
    )
    private String state;

    @Schema(description = "The city's name.",
        example = "Santo André",
        required = true
    )
    private String city;

    @Schema(description = "The neighborhood's name.",
        example = "Bairro Jardim",
        required = true
    )
    private String neighborhood;

    @Schema(description = "The name of the street or avenue.",
        example = "Rua das Figueiras",
        required = true
    )
    private String address;

    @Schema(description = "The number where the place is on the street, avenue, etc.",
        example = "1274",
        required = true
    )
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
    private String zipCode;

}
