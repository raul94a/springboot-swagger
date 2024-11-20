package com.raul.demoopenapi.users.controller;

import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.models.CreateUserBody;
import com.raul.demoopenapi.users.persistence.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IUserController {
    @Operation(summary = "MyDescription for this api, it can be stored in the application.yml resource file",
            description = "Detailed description for this Endpoint"
    )
    @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = User.class))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> getUsers();

    @Operation(summary = "MyDescription for this api, it can be stored in the application.yml resource file",
            description = "Detailed description for this Endpoint"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE
                                    , schema = @Schema(implementation = User.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
            }
    )
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User getUser(@PathVariable Long id) throws NotFoundException;

    @Operation(summary = "MyDescription for this api, it can be stored in the application.yml resource file",
            description = "Detailed description for this Endpoint"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class))
                    }),
            }
    )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    User create(@RequestBody CreateUserBody body);

    @Operation(summary = "MyDescription for this api, it can be stored in the application.yml resource file",
            description = "Detailed description for this Endpoint"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
            }
    )
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Long id);
}
