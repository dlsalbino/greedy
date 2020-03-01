package br.com.azusah.greedy.framework.controllers.resources.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseResponse {

    private String id;
    private String title;
    private String modality;
    private String description;
    private LocalDate start;
    private LocalDate finish;
    private String instructor;
    private String audience;
    private LocationResponse location;
    private String url;

}
