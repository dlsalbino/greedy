package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.CourseResource;
import br.com.azusah.greedy.framework.mappers.Mapper;
import br.com.azusah.greedy.framework.repositories.entities.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something was wrong during creation.");
        }

    }

    @Override
    public CourseResource getOne(String id) {
        return courseRepository.getOne(id)
                .map(c -> modelMapper.mapper().map(c, CourseResource.class))
                .orElse(null);
    }

    @Override
    public List<CourseResource> getAll() {
        return courseRepository.getAll()
                .stream()
                .map(c -> modelMapper.mapper().map(c, CourseResource.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseResource update(CourseResource courseResource) {
        if (courseResource.getId() == null
                || courseResource.getId().isEmpty()
                || courseResource.getId().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must provide a valid 'id'!");
        }

        CourseResource courseFound = getOne(courseResource.getId());

        if (courseFound == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with id: '" + courseResource.getId() + "' not found!");
        }

        courseFound.setTitle(courseResource.getTitle());
        courseFound.setModality(courseResource.getModality());
        courseFound.setStart(courseResource.getStart());
        courseFound.setFinish(courseResource.getFinish());
        courseFound.setInstructor(courseResource.getInstructor());
        courseFound.setAudience(courseResource.getAudience());
        courseFound.setLocation(courseResource.getLocation());
        courseFound.setUrl(courseResource.getUrl());

        Course updatedCourse = courseRepository.update(modelMapper.mapper().map(courseFound, Course.class));
        return modelMapper.mapper().map(updatedCourse, CourseResource.class);
    }
}
