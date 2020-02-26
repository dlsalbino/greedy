package br.com.azusah.greedy.framework.repositories.entities;

import br.com.azusah.greedy.framework.repositories.entities.enums.StateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String country;
    private StateType state;
    private String city;
    private String neighborhood;
    private String address;
    private String number;
    private String complement;
    private String zipCode;

}
