package br.com.azusah.greedy.core.validators;

import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.repositories.entities.enums.ModalityType;
import org.springframework.stereotype.Service;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.26
 */
@Service
public class InsertionRuleValidator {

    public boolean validateInsertion(CourseRequest course) {
        if (course.getModality().equalsIgnoreCase(ModalityType.PRESENTIAL.toString())
                && course.getLocation() != null) {
            return true;
        }
        if (course.getModality().equalsIgnoreCase(ModalityType.ONLINE.toString())
                && course.getUrl() != null && course.getLocation() == null) {
            return true;
        } else {
            return false;
        }
    }


}
