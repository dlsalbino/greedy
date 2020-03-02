package br.com.azusah.greedy.boundary.ports;

import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;

import java.util.List;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
public interface ICourseServicePort {

    CourseResponse insert(CourseRequest courseRequest);

    CourseResponse getOne(String id);

    List<CourseResponse> getAll();

    CourseResponse update(String id, CourseRequest courseRequest);

    void deleteInALogicalWay(String id);
}
