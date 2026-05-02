package com.guicedee.examples.auth.htpasswd;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource secured with htpasswd authentication.
 * <p>
 * htpasswd provides AuthN only — users are verified against the .htpasswd file.
 */
@Path("api/secure")
@Produces("application/json")
public class SecuredResource
{
    @GET
    @Path("home")
    @PermitAll
    public String home()
    {
        return "{\"message\": \"Authenticated via htpasswd file\"}";
    }
}

