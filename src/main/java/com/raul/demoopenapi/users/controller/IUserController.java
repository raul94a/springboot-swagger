package com.raul.demoopenapi.users.controller;

import com.raul.demoopenapi.common.ApiPager;
import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.models.CreateUserBody;
import com.raul.demoopenapi.users.persistence.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "Users"
)
public interface IUserController {
    @Operation(summary = "Get All Users",
            description = "Get All users supports pagination, see the query for more information."
    )
    @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ApiPager.class))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ApiPager<User> getUsers(@RequestParam Integer page, @RequestParam Integer size);

    @Operation(summary = "Get a single user by id",
            description = "Pass the id to retrieve a single user from the database."
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

    @Operation(summary = "Create new users",
            description = ""
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class))
                    }),
            }
    )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User create(@RequestBody CreateUserBody body);

    @Operation(summary = "Create new users",
            description = ""
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class))
                    }),
            }
    )
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User update(@PathVariable Long id, @RequestBody User user);

    @Operation(summary = "Deletes an user",
            description = "The user object can be deleted by using the user id."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "OK"),
            }
    )
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Long id);
}
