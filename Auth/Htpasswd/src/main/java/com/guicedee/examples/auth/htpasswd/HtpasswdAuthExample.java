package com.guicedee.examples.auth.htpasswd;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.GuiceApplication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates htpasswd authentication with GuicedEE.
 * <p>
 * Uses Apache-style .htpasswd file for Basic auth.
 * Generate passwords with: {@code htpasswd -B .htpasswd username}
 * <p>
 * Test with:
 * <pre>
 * curl -u admin:password http://localhost:8080/api/secure/home
 * </pre>
 */
public class HtpasswdAuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        GuiceApplication.run(() -> {
            IGuiceContext.registerModule("com.guicedee.examples.auth.htpasswd");
            IGuiceContext.getContext().getConfig().setServiceLoadWithClassPath(true);
        });

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("htpasswd Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

