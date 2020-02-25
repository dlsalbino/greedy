package br.com.azusah.greedy.boundary.ports;

import br.com.azusah.greedy.framework.controllers.resources.CourseResource;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public interface ICourseServicePort {

    String create(CourseResource courseResource);

}
