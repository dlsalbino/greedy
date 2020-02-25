package br.com.azusah.greedy.boundary.adapters;

import br.com.azusah.greedy.boundary.ports.ICourseRepository;
import br.com.azusah.greedy.framework.controllers.CourseResource;
import br.com.azusah.greedy.framework.repositories.CourseMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public class CourseRepositoryAdapter implements ICourseRepository {

    @Autowired
    private CourseMongoRepository courseMongoRepository;

    @Override
    public String create(CourseResource courseResource) {
        return null;
    }
}
