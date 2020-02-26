package br.com.azusah.greedy.framework.controllers.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResource {

    private String id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Min(3)
    private String title;

}
