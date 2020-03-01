package br.com.azusah.greedy.framework.controllers.resources.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocationResponse {

    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String address;
    private String number;
    private String complement;
    private String zipCode;

}
