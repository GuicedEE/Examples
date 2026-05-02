package com.guicedee.examples.auth.jwt;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource secured with JWT authentication.
 * <p>
 * The {@code /api/secure/public} endpoint is open to all authenticated users.
 * The {@code /api/secure/admin} endpoint requires the "admin" role from the JWT token.
 */
@Path("api/secure")
@Produces("application/json")
public class SecuredResource
{
    @GET
    @Path("public")
    @PermitAll
    public String publicEndpoint()
    {
        return "{\"message\": \"This endpoint is open to all authenticated users\"}";
    }

    @GET
    @Path("admin")
    @RolesAllowed("admin")
    public String adminEndpoint()
    {
        return "{\"message\": \"This endpoint requires the admin role\"}";
    }
}

