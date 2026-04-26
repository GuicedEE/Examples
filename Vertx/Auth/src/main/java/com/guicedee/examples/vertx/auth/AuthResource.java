package com.guicedee.examples.vertx.auth;

import com.google.inject.Inject;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.properties.PropertyFileAuthentication;
import io.vertx.ext.auth.properties.PropertyFileAuthorization;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Auth REST resource demonstrating JWT login and role-based access control.
 */
@Path("/api/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource
{
    @Inject
    private JWTAuth jwtAuth;

    @Inject
    private PropertyFileAuthentication propertyAuth;

    @Inject
    private PropertyFileAuthorization propertyAuthz;

    /**
     * Login endpoint — validates username/password against the property file,
     * then issues a JWT token with the user's roles embedded.
     */
    @POST
    @Path("/login")
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(JsonObject body)
    {
        String username = body.getString("username");
        String password = body.getString("password");

        try
        {
            var user = propertyAuth.authenticate(new UsernamePasswordCredentials(username, password))
                    .toCompletionStage().toCompletableFuture().join();

            // Load authorizations so we can embed roles in the token
            propertyAuthz.getAuthorizations(user)
                    .toCompletionStage().toCompletableFuture().join();

            // Generate JWT
            String token = jwtAuth.generateToken(
                    new JsonObject()
                            .put("sub", username)
                            .put("name", username),
                    new JWTOptions().setAlgorithm("HS256"));

            return Response.ok(new JsonObject()
                    .put("token", token)
                    .put("type", "Bearer")
                    .encode()).build();
        }
        catch (Exception e)
        {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new JsonObject().put("error", "Invalid credentials").encode())
                    .build();
        }
    }

    /**
     * Protected endpoint — any authenticated user can access.
     */
    @GET
    @Path("/me")
    public Response me()
    {
        return Response.ok(new JsonObject()
                .put("message", "You are authenticated!")
                .encode()).build();
    }

    /**
     * Admin-only endpoint — requires 'administrator' role.
     */
    @GET
    @Path("/admin")
    @RolesAllowed("administrator")
    public Response admin()
    {
        return Response.ok(new JsonObject()
                .put("message", "Welcome, administrator!")
                .encode()).build();
    }
}

