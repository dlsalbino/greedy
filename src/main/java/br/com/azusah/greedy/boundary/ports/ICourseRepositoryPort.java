package br.com.azusah.greedy.boundary.ports;

import br.com.azusah.greedy.framework.repositories.entities.Course;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public interface ICourseRepositoryPort {

    String create(Course course);
}
