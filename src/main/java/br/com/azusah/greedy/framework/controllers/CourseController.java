package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.core.CourseService;
import br.com.azusah.greedy.framework.controllers.resources.CourseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseServicePort) {
        this.courseService = courseServicePort;
    }

    @PostMapping
    String create(@RequestBody CourseResource courseResource) {
        courseService.create(courseResource);
        return "The course was created";
    }

    @GetMapping
    String retrieveAll() {
        return "Here is your list of courses.";
    }

}
