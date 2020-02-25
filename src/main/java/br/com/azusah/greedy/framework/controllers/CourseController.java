package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.CourseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    ResponseEntity<CourseResource> create(@RequestBody CourseResource courseResource) {
        CourseResource createdCourse = courseServicePort.create(courseResource);
        return new ResponseEntity<CourseResource>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<CourseResource> getOne(@PathVariable String id) {
        courseServicePort.getOne(id);
        return null;
    }

}
