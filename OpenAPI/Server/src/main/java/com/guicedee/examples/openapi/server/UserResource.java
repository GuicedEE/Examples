package com.guicedee.examples.openapi.server;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * REST resource with Swagger/OpenAPI annotations.
 * The OpenAPI spec is auto-generated and served at /openapi.json and /openapi.yaml.
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource
{
    @GET
    @Path("/{id}")
    @Operation(summary = "Get user by ID", description = "Returns a single user by their ID")
    @ApiResponse(responseCode = "200", description = "User found")
    @ApiResponse(responseCode = "404", description = "User not found")
    public UserResponse getUser(@Parameter(description = "User ID") @PathParam("id") Long id)
    {
        return new UserResponse(id, "John Doe", "john@example.com");
    }

    @GET
    @Operation(summary = "List all users")
    @ApiResponse(responseCode = "200", description = "List of users")
    public List<UserResponse> listUsers()
    {
        return List.of(
                new UserResponse(1L, "John Doe", "john@example.com"),
                new UserResponse(2L, "Jane Doe", "jane@example.com")
        );
    }
}
