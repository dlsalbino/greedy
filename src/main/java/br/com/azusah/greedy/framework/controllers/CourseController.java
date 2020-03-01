package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.request.CourseResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
@Tag(name = "Course", description = "A course resource.")
public class CourseController {

    private final ICourseServicePort courseServicePort;

    @Operation(summary = "returns a resource saved on database.",
            description = "Given a valid resource saves it on database and returns the object saved.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "resource created on database",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResource.class)))),
            @ApiResponse(responseCode = "400", description = "Some data on resource body is invalid.")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CourseResource insert(@Parameter(description = "Course to insert. Must have valid fields.",
            required = true, schema = @Schema(implementation = CourseResource.class))
                          @Valid @RequestBody CourseResource courseResource) {
        return courseServicePort.insert(courseResource);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    CourseResource getOne(@PathVariable String id) {
        CourseResource courseResource = courseServicePort.getOne(id);
        if (courseResource != null) {
            return courseResource;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with id: " + id + " not found!");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
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
