package com.guicedee.examples.auth.otp;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST resource secured with OTP (Time-Based One-Time Password) authentication.
 * <p>
 * OTP provides AuthN only. Users must present a valid TOTP code.
 */
@Path("api/secure")
@Produces("application/json")
public class SecuredResource
{
    @GET
    @Path("dashboard")
    @PermitAll
    public String dashboard()
    {
        return "{\"message\": \"Authenticated via TOTP — welcome to the dashboard\"}";
    }
}

