package br.com.azusah.greedy.boundary.ports;

import br.com.azusah.greedy.framework.controllers.resources.CourseResource;

import java.util.List;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public interface ICourseServicePort {

    CourseResource create(CourseResource courseResource);

    CourseResource getOne(String id);

    List<CourseResource> getAll();
}
