package br.com.azusah.greedy.framework.repositories.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Document
public class Course {

    @Id
    private String id;

    @Min(3)
    private String title;
}
