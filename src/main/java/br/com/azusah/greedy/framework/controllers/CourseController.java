package br.com.azusah.greedy.framework.controllers;

import br.com.azusah.greedy.boundary.ports.ICourseServicePort;
import br.com.azusah.greedy.framework.controllers.resources.request.CourseRequest;
import br.com.azusah.greedy.framework.controllers.resources.response.CourseResponse;
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

    @Operation(summary = "Saves a resource on database and returns it.",
            description = "Given a valid resource saves it on database and returns the object saved.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "resource created on database",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Some data on resource body is invalid.")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CourseResponse insert(@Parameter(description = "Course to insert. Must have valid fields.",
            required = true, schema = @Schema(implementation = CourseRequest.class))
                          @Valid @RequestBody final CourseRequest courseRequest) {
        return courseServicePort.insert(courseRequest);
    }

    @Operation(summary = "Returns a resource saved on database.",
            description = "Given a valid id, returns a resource saved on database.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found on database",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class)))),
            @ApiResponse(responseCode = "404", description = "Resource not found with given id.")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CourseResponse getOne(@PathVariable final String id) {
        CourseResponse courseResponse = courseServicePort.getOne(id);
        if (courseResponse != null) {
            return courseResponse;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with id: " + id + " not found!");
        }
    }

    @Operation(summary = "Returns a list of resources saved on database.",
            description = "Just returns a list of resources saved on database.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of resources",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class))))
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<CourseResponse> getAll() {
        return courseServicePort.getAll();
    }

    @Operation(summary = "Updates a resource on database.",
            description = "Given a valid id, and a valid body, updates the object on database and returns it.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "resource created on database",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Some data on resource body is invalid."),
            @ApiResponse(responseCode = "404", description = "Resource not found with given id.")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CourseResponse update(@PathVariable final String id, @RequestBody final CourseRequest courseRequest) {
        return courseServicePort.update(id, courseRequest);
    }

    @Operation(summary = "Returns a message of success with id of the deleted object.",
            description = "Given a valid id, returns a message of success on deleting processes.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "resource created on database",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class)))),
            @ApiResponse(responseCode = "404", description = "Resource not found with given id.")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    String delete(@PathVariable final String id) {
        return courseServicePort.deleteInALogicalWay(id);
    }

}
