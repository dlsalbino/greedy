package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Daniel L. B. Albino (daniel.albino@gmail.com)
 * @since 2020.02.25
 */
@Slf4j
@RequiredArgsConstructor
public class CourseController implements ApiController {

    private final ICourseServicePort courseServicePort;

    @Override
    public CourseResponse insert(@Valid @RequestBody final CourseRequest courseRequest) {
        log.info("Starting an insert for {}.", courseRequest.getTitle());
        CourseResponse response = courseServicePort.insert(courseRequest);
        log.info("Ending insert process {}.", courseRequest.getTitle());
        log.debug("Course inserted: [{}]", response);
        return response;
    }

    @Override
    public CourseResponse getById(@Parameter(description = "Id of the course to be obtained. Cannot be empty.", required = true)
                                  @PathVariable final String id) {
        log.info("Starting search for course with id: {}", id);
        CourseResponse courseResponse = courseServicePort.getOne(id);
        if (courseResponse != null) {
            log.info("Ending search for course with id: {}", id);
            log.debug("Course found: [{}]", courseResponse);
            return courseResponse;
        } else {
            log.info("Ending. There is no course with id: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with id: " + id + " not found!");
        }
    }

    @Override
    public List<CourseResponse> getAll() {
        log.info("Starting search for all courses.");
        List<CourseResponse> courses = courseServicePort.getAll();
        log.debug("You have a list with {} courses", courses.size());
        log.info("Ending search for all courses.");
        return courses;
    }

    @Override
    public CourseResponse update(@Parameter(description = "Id of the course to be updated. Cannot be empty.", required = true)
                                 @PathVariable final String id, @Valid @RequestBody final CourseRequest courseRequest) {
        log.info("Starting update for course with id: {}", id);
        log.debug("Course to be updated: [{}]", courseRequest);
        CourseResponse courseResponse = courseServicePort.update(id, courseRequest);
        log.info("Ending update for course with id: {}", id);
        log.debug("Course updated: [{}]", courseResponse);
        return courseResponse;
    }

    @Override
    public void delete(@Parameter(description = "Id of the course to be deleted. Cannot be empty.", required = true)
                       @PathVariable final String id) {
        log.info("Starting exclude process for course with id: {}", id);
        courseServicePort.deleteInALogicalWay(id);
        log.info("Ending exclude process for course with id: {}", id);
    }

}
