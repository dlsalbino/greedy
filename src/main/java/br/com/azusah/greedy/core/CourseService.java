package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.core.exceptions.CourseException;
import br.com.azusah.greedy.framework.controllers.resources.CourseResource;
import br.com.azusah.greedy.framework.mappers.Mapper;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Service
@RequiredArgsConstructor
public class CourseService implements ICourseServicePort {

    private final ICourseRepositoryPort courseRepository;
    private final Mapper modelMapper;

    @Override
    public CourseResource create(CourseResource courseResource) {

        try {
            Course savedCourse = courseRepository.create(modelMapper.mapper().map(courseResource, Course.class));
            return modelMapper.mapper().map(savedCourse, CourseResource.class);
        } catch (Exception e) {
            throw new CourseException("Something was wrong during creation.", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public CourseResource getOne(String id) {
        return courseRepository.getOne(id)
                .map(c -> modelMapper.mapper().map(c, CourseResource.class))
                .orElse(null);
    }
}
