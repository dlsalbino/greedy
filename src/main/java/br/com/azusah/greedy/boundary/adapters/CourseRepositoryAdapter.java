package br.com.azusah.greedy.boundary.adapters;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.framework.repositories.CourseMongoRepository;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Course savedCourse = courseMongoRepository.save(course);
        System.out.println("Saved course: " + savedCourse.toString());
        return savedCourse;
    }

}
