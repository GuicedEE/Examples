package com.guicedee.examples.auth.htdigest;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates htdigest (HTTP Digest) authentication with GuicedEE.
 * <p>
 * Uses Apache-style .htdigest file for Digest auth (more secure than Basic over HTTP).
 * Generate entries with: {@code htdigest -c .htdigest "example-realm" username}
 * <p>
 * Test with:
 * <pre>
 * curl --digest -u admin:password http://localhost:8080/api/secure/home
 * </pre>
 */
public class HtdigestAuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.auth.htdigest");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("htdigest Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

