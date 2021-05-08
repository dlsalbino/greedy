package br.com.azusah.greedy.framework.controllers;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
@Tag(name = "Course", description = "A course resource.")
public interface ApiController {

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
    CourseResponse insert(@Valid @RequestBody final CourseRequest courseRequest);

    @Operation(summary = "Returns a resource saved on database.",
            description = "Given a valid id, returns a resource saved on database.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource found on database",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class)))),
            @ApiResponse(responseCode = "404", description = "Resource not found with given id.")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    CourseResponse getById(@Parameter(description = "Id of the course to be obtained. Cannot be empty.", required = true)
                           @PathVariable final String id);

    @Operation(summary = "Returns a list of resources saved on database.",
            description = "Just returns a list of resources saved on database.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of resources",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class))))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<CourseResponse> getAll();

    @Operation(summary = "Updates a resource on database.",
            description = "Given a valid id, and a valid body, updates the object on database and returns it.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful updated ",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Some data on resource body is invalid."),
            @ApiResponse(responseCode = "404", description = "Resource not found with given id.")
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    CourseResponse update(@Parameter(description = "Id of the course to be updated. Cannot be empty.", required = true)
                          @PathVariable final String id, @Valid @RequestBody final CourseRequest courseRequest);

    @Operation(summary = "Returns a message of success with id of the deleted object.",
            description = "Given a valid id, returns a message of success on deleting processes.",
            tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "resource deleted on database"),
            @ApiResponse(responseCode = "404", description = "Resource not found with given id.")
    })
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@Parameter(description = "Id of the course to be deleted. Cannot be empty.", required = true)
                @PathVariable final String id);

}
