package com.guicedee.examples.auth.properties;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource secured with Property File authentication.
 * <p>
 * Users and roles are defined in {@code auth.properties}.
 * This provider supports both AuthN and AuthZ.
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
        return "{\"message\": \"Open to all authenticated users (admin, alice, bob)\"}";
    }

    @GET
    @Path("admin")
    @RolesAllowed("administrator")
    public String adminEndpoint()
    {
        return "{\"message\": \"Requires the administrator role (only admin user)\"}";
    }

    @GET
    @Path("dev")
    @RolesAllowed("developer")
    public String developerEndpoint()
    {
        return "{\"message\": \"Requires the developer role (admin and alice)\"}";
    }
}

