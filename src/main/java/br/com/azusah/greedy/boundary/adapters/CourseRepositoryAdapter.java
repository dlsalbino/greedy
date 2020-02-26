package br.com.azusah.greedy.boundary.adapters;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.framework.repositories.CourseMongoRepository;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Service
public class CourseRepositoryAdapter implements ICourseRepositoryPort {

    @Autowired
    private CourseMongoRepository courseMongoRepository;

    @Override
    public Course create(Course course) {
        return courseMongoRepository.save(course);
    }

    @Override
    public Optional<Course> getOne(String id) {
        return courseMongoRepository.findById(id);
    }

}
