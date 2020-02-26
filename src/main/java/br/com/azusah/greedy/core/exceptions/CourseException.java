package br.com.azusah.greedy.core.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public class CourseException extends RuntimeException {

    public CourseException(String message, HttpStatus httpStatus) {
        super(message);
    }
}
