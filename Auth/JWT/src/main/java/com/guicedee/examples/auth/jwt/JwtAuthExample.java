package com.guicedee.examples.auth.jwt;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates JWT authentication with GuicedEE.
 * <p>
 * Starts the application with Vert.x HTTP server and JWT auth configured
 * via the {@code @JwtAuthOptions} annotation on the package-info.
 * <p>
 * Test with:
 * <pre>
 * # Generate a token (implementation-specific) then:
 * curl -H "Authorization: Bearer &lt;token&gt;" http://localhost:8080/api/secure/public
 * curl -H "Authorization: Bearer &lt;token&gt;" http://localhost:8080/api/secure/admin
 * </pre>
 */
public class JwtAuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.auth.jwt");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("JWT Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

