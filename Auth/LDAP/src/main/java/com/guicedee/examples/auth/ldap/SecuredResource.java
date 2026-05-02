package com.guicedee.examples.auth.ldap;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource secured with LDAP authentication.
 * <p>
 * LDAP provides AuthN only. Users are authenticated against the
 * LDAP directory configured in the package-info annotation.
 */
@Path("api/secure")
@Produces("application/json")
public class SecuredResource
{
    @GET
    @Path("profile")
    @PermitAll
    public String profile()
    {
        return "{\"message\": \"Authenticated via LDAP directory\"}";
    }
}

