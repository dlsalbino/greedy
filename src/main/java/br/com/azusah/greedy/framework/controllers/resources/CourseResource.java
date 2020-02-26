package br.com.azusah.greedy.framework.controllers.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseResource {

    private String id;

    @NotBlank
    @Size(min = 3)
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
