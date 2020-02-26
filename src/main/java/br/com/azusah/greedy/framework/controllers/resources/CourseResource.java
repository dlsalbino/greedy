package br.com.azusah.greedy.framework.controllers.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResource {

    private String id;

    @NotBlank
    @Min(3)
    private String title;

    @NotBlank
    private String modality;

    private String description;

    @Future
    private LocalDate start;

    @Future
    private LocalDate finish;

    @NotBlank
    private String instructor;

    @NotBlank
    private String audience;

    @Valid
    private LocationResource location;

    @URL
    private String url;

}
