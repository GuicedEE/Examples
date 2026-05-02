package com.guicedee.examples.auth.properties;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Property File authentication with GuicedEE.
 * <p>
 * Users and roles are loaded from {@code auth.properties} (Apache Shiro format).
 * This is the simplest auth provider — no external services required.
 * <p>
 * Test with Basic auth:
 * <pre>
 * curl -u admin:admin123 http://localhost:8080/api/secure/public
 * curl -u admin:admin123 http://localhost:8080/api/secure/admin
 * curl -u alice:password1 http://localhost:8080/api/secure/dev
 * curl -u bob:password2 http://localhost:8080/api/secure/admin   # 403 Forbidden
 * </pre>
 */
public class PropertyFileAuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.auth.properties");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Property File Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

