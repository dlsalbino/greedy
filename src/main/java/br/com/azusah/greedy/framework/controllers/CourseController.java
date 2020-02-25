package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.boundary.ports.ICoursePort;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CourseController {

    private final ICoursePort coursePort;

    @PostMapping
    String create(@RequestBody CourseResource courseResource){
        coursePort.create(courseResource);
        return "The course was created";
    }

    @GetMapping
    String retrieveAll(){
        return "Here is your list of courses.";
    }

}
