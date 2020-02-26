package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.CourseResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@Tag(name = "course", description = "A course resource.")
public class CourseController {

    private final ICourseServicePort courseServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CourseResource insert(@Valid @RequestBody CourseResource courseResource) {
        return courseServicePort.insert(courseResource);
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

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    CourseResource update(@RequestBody CourseResource courseResource) {
        return courseServicePort.update(courseResource);
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable String id) {
        return courseServicePort.deleteInALogicalWay(id);
    }

}
