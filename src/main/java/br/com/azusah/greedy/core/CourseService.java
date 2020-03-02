package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepositoryPort;
import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.core.validators.InsertionRuleValidator;
import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;
import br.com.azusah.greedy.framework.controllers.resources.response.LocationResponse;
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

    private final Mapper modelMapper;
    private final ICourseRepositoryPort courseRepository;
    private final InsertionRuleValidator insertionRuleValidator;

    @Override
    public CourseResponse insert(CourseRequest courseRequest) {
        //TODO: Improve the way of validation it.
        List<String> errors = insertionRuleValidator.validate(courseRequest);
        if (!errors.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

        Course savedCourse = courseRepository.insert(modelMapper.mapper().map(courseRequest, Course.class));
        return modelMapper.mapper().map(savedCourse, CourseResponse.class);
    }

    @Override
    public CourseResponse getOne(String id) {
        return courseRepository.getOne(id)
                .map(c -> modelMapper.mapper().map(c, CourseResponse.class))
                .orElse(null);
    }

    @Override
    public List<CourseResponse> getAll() {
        return courseRepository.getAll()
                .stream()
                .map(c -> modelMapper.mapper().map(c, CourseResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse update(String id, CourseRequest courseRequest) {
        if (id == null || id.isEmpty() || id.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must provide a valid 'id'!");
        }

        CourseResponse courseFound = getOne(id);

        if (courseFound == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Course with id: '" + id + "' was not found!");
        }

        courseFound.setTitle(courseRequest.getTitle());
        courseFound.setDescription(courseRequest.getDescription());
        courseFound.setModality(courseRequest.getModality());
        courseFound.setStart(courseRequest.getStart());
        courseFound.setFinish(courseRequest.getFinish());
        courseFound.setInstructor(courseRequest.getInstructor());
        courseFound.setAudience(courseRequest.getAudience());
        courseFound.setLocation(modelMapper.mapper().map(courseRequest.getLocation(), LocationResponse.class));
        courseFound.setUrl(courseRequest.getUrl());

        Course updatedCourse = courseRepository.update(modelMapper.mapper().map(courseFound, Course.class));
        return modelMapper.mapper().map(updatedCourse, CourseResponse.class);
    }

    @Override
    public void deleteInALogicalWay(String id) {
        if (id == null || id.isEmpty() || id.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must provide a valid 'id'!");
        }

        courseRepository.getOne(id)
                .map(c -> {
                    if (!c.isActive())
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Course with id: '" + id + "' is already deleted!");

                    c.setActive(false);
                    courseRepository.update(c);
                    return c;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Course with id: '" + id + "' was not found!"));

    }

}
