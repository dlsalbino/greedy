package br.com.azusah.greedy.core.validators;

import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.repositories.entities.enums.ModalityType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.26
 */
@Service
public class InsertionRuleValidator {

    public List<String> validate(CourseRequest course) {
        List<String> errors = new ArrayList<>();

        if (course.getModality().equalsIgnoreCase(ModalityType.PRESENTIAL.toString())
                && course.getLocation() == null) {
            errors.add("Presential courses needs a location");
        }

        if (course.getModality().equalsIgnoreCase(ModalityType.ONLINE.toString())
                && course.getUrl() == null) {
            errors.add("Online courses needs a url");
        }

        if (course.getModality().equalsIgnoreCase(ModalityType.ONLINE.toString())
                && course.getLocation() != null) {
            errors.add("Online courses cannot have an location");
        }

        if (course.getFinish().isBefore(course.getStart())) {
            errors.add("The start date cannot be after finish date");
        }

        return errors;
    }

}
