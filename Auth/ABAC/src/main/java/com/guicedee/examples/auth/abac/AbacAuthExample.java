package com.guicedee.examples.auth.abac;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates ABAC (Attribute-Based Access Control) authorization with GuicedEE.
 * <p>
 * ABAC provides AuthZ only — this example pairs it with JWT for AuthN.
 * Policies are defined inline in the {@code @AbacOptions} annotation on the package-info.
 */
public class AbacAuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.auth.abac");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("ABAC Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

