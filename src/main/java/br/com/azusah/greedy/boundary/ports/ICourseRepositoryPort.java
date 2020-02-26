package br.com.azusah.greedy.boundary.ports;

import br.com.azusah.greedy.framework.repositories.entities.Course;

import java.util.List;
import java.util.Optional;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public interface ICourseRepositoryPort {

    Course create(Course course);

    Optional<Course> getOne(String id);

    List<Course> getAll();
}
