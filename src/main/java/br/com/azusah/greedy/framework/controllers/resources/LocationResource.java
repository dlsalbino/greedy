package br.com.azusah.greedy.framework.controllers.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationResource {

    @NotBlank
    private String country;

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String address;

    @NotBlank
    private String number;

    private String complement;

    @NotBlank
    private String zipCode;

}
