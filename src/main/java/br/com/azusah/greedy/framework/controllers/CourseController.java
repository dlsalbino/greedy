package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.CourseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@RestController
@RequestMapping(value = "/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseServicePort courseServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CourseResource create(@Valid @RequestBody CourseResource courseResource) {
        return courseServicePort.create(courseResource);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CourseResource getOne(@PathVariable String id) {
        CourseResource courseResource = courseServicePort.getOne(id);
        if (courseResource != null) {
            return courseResource;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with id: " + id + " not found!");
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CourseResource> getAll() {
        return courseServicePort.getAll();
    }

}
