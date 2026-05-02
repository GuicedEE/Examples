package com.guicedee.examples.auth.abac;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource demonstrating ABAC policy-based authorization.
 * <p>
 * Access is controlled by attribute-based policies defined in the package-info.
 * Users in the "admin" group get full access; "developer" group gets read-only.
 */
@Path("api/resources")
@Produces("application/json")
public class SecuredResource
{
    @GET
    @PermitAll
    public String list()
    {
        return "{\"message\": \"List resources — permitted for all authenticated users\"}";
    }

    @GET
    @Path("admin")
    @RolesAllowed("admin")
    public String adminOnly()
    {
        return "{\"message\": \"Admin-only resource — ABAC policy grants wildcard to admin group\"}";
    }

    @DELETE
    @Path("dangerous")
    @DenyAll
    public String dangerous()
    {
        return "{\"message\": \"This endpoint is denied to all by @DenyAll\"}";
    }
}

