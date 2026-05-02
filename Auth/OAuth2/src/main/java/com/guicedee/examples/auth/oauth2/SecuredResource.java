package com.guicedee.examples.auth.oauth2;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource secured with OAuth2/OIDC authentication.
 * <p>
 * OAuth2 provides AuthN only — combine with JWT or ABAC for role-based authorization.
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
        return "{\"message\": \"Authenticated via OAuth2 — user profile endpoint\"}";
    }

    @GET
    @Path("admin")
    @RolesAllowed("admin")
    public String admin()
    {
        return "{\"message\": \"Requires admin role (needs additional AuthZ provider)\"}";
    }
}

