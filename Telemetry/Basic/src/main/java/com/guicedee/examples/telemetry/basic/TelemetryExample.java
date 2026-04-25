package com.guicedee.examples.telemetry.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates OpenTelemetry distributed tracing with @Trace and @SpanAttribute annotations.
 * Spans are automatically created via Guice AOP and exported to the configured OTLP endpoint.
 */
public class TelemetryExample
{
    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.telemetry.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Telemetry example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        TracedService service = IGuiceContext.get(TracedService.class);
        service.processOrder("ORD-001", 99.99);

        System.out.println("Traces exported to configured OTLP endpoint");
    }
}

