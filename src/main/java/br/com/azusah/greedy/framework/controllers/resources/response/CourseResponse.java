package br.com.azusah.greedy.framework.controllers.resources.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseResponse {

    @Schema(description = "Unique identifier of the Course.",
        example = "5e56c653ca6a004f9b007151",
        required = false
    )
    private String id;

    @Schema(description = "The name of the course.",
        example = "Spring Boot with OpenApi Documentation. :-P",
        required = true
    )
    @NotBlank
    @Size(min = 3)
    private String title;

    @Schema(description = "The way how this course will be offered.",
        example = "PRESENTIAL",
        required = true
    )
    @NotBlank
    private String modality;

    @Schema(description = "Soon description about the course",
        example = "The course will teach you everything about nothing.",
        required = false
    )
    private String description;

    @Schema(description = "Date when the course starts",
        example = "2020-02-26",
        required = true
    )
    @Future
    private LocalDate start;

    @Schema(description = "Date when the course ends",
        example = "2020-02-26",
        required = true
    )
    @Future
    private LocalDate finish;

    @Schema(description = "The instructor's name(s).",
        example = "Qui-Gon Jinn, Obi Wan Kenobi, Mace Windu",
        required = true
    )
    @NotBlank
    private String instructor;

    @Schema(description = "For who is the course.",
        example = "ANYONE",
        required = true
    )
    @NotBlank
    private String audience;

    @Schema(description = "For PRESENTIAL courses, the place where will happen.",
        example = "A location resource.",
        required = true
    )
    @Valid
    private LocationResponse location;

    @Schema(description = "For ONLINE courses, the URL where it can be found.",
        example = "http://udemy.com/id-of-the-course",
        required = true
    )
    @URL
    private String url;

}
