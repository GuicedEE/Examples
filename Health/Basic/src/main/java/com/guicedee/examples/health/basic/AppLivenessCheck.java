package com.guicedee.examples.health.basic;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

/**
 * A simple liveness health check.
 * Discovered automatically via ClassGraph — no SPI registration needed.
 * Accessible at GET /health/live after bootstrap.
 */
@Liveness
public class AppLivenessCheck implements HealthCheck
{
    @Override
    public HealthCheckResponse call()
    {
        return HealthCheckResponse.named("app-liveness")
                .up()
                .withData("version", "2.0.1-SNAPSHOT")
                .build();
    }
}

