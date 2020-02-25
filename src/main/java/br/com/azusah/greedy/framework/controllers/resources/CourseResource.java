package br.com.azusah.greedy.framework.controllers.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResource {

    @JsonProperty
    private String title;

}
