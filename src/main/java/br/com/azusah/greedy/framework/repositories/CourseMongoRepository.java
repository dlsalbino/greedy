package br.com.azusah.greedy.framework.repositories;

import br.com.azusah.greedy.framework.repositories.entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Repository
public interface CourseMongoRepository extends MongoRepository<Course, String> {

    List<Course> findCourseByActiveTrue();

}
