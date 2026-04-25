package com.guicedee.examples.health.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates MicroProfile Health with @Liveness and @Readiness checks.
 * After bootstrap, health endpoints are available:
 * <ul>
 *   <li>GET /health — aggregated status</li>
 *   <li>GET /health/live — liveness checks</li>
 *   <li>GET /health/ready — readiness checks</li>
 * </ul>
 */
public class HealthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.health.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Health example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
        System.out.println("Health endpoints available at /health, /health/live, /health/ready");
    }
}

