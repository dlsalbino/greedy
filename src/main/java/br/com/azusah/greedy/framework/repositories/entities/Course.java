package br.com.azusah.greedy.framework.repositories.entities;

import br.com.azusah.greedy.framework.repositories.entities.enums.AudienceType;
import br.com.azusah.greedy.framework.repositories.entities.enums.ModalityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    private String id;
    private String title;
    private ModalityType modality;
    private String description;
    private LocalDate start;
    private LocalDate finish;
    private String instructor;
    private AudienceType audience;
    private Location location;
    private String url;

}
