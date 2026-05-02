package com.guicedee.examples.auth.htdigest;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource secured with htdigest (HTTP Digest) authentication.
 * <p>
 * htdigest provides AuthN only — users are verified against the .htdigest file
 * using HTTP Digest authentication (more secure than Basic over plain HTTP).
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
        return "{\"message\": \"Authenticated via HTTP Digest (htdigest file)\"}";
    }
}

