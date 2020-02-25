package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.CourseResource;
import br.com.azusah.greedy.framework.mappers.Mapper;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Service
public class CourseService implements ICourseServicePort {

    @Autowired
    private ICourseRepositoryPort courseRepository;

    @Autowired
    Mapper modelMapper;

    @Override
    public String create(CourseResource courseResource) {
        Course course = modelMapper.mapper().map(courseResource, Course.class);
        System.out.println("Wait while your course is created...");
        courseRepository.create(course);
        System.out.println("Course is created!");
        return "created!";
    }
}
