package br.com.azusah.greedy.core;

import br.com.azusah.greedy.boundary.ports.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public class CourseBusiness {

    @Autowired
    private ICourseRepository courseRepository;

    public String create() {
        System.out.println("Wait while your course is created...");
        System.out.println("Course is created!");
        return "created!";
    }
}
