package com.guicedee.examples.health.basic;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 * A simple readiness health check.
 * Accessible at GET /health/ready after bootstrap.
 */
@Readiness
public class AppReadinessCheck implements HealthCheck
{
    @Override
    public HealthCheckResponse call()
    {
        return HealthCheckResponse.named("app-readiness")
                .up()
                .withData("database", "connected")
                .build();
    }
}

