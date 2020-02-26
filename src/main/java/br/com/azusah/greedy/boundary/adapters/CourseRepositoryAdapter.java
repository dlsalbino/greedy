package br.com.azusah.greedy.boundary.adapters;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.framework.repositories.CourseMongoRepository;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Service
@RequiredArgsConstructor
public class CourseRepositoryAdapter implements ICourseRepositoryPort {

    private final CourseMongoRepository courseMongoRepository;

    @Override
    public Course insert(Course course) {
        return courseMongoRepository.insert(course);
    }

    @Override
    public Optional<Course> getOne(String id) {
        return courseMongoRepository.findById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseMongoRepository.findCourseByActiveTrue();
    }

    @Override
    public Course update(Course course) {
        return courseMongoRepository.save(course);
    }

}
