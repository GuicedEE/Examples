package com.guicedee.examples.metrics.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates MicroProfile Metrics with @Counted and @Timed annotations.
 * After bootstrap, Prometheus scrape endpoint is available at GET /metrics.
 */
public class MetricsExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.metrics.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Metrics example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        OrderService orderService = IGuiceContext.get(OrderService.class);
        System.out.println(orderService.placeOrder("Widget"));
        System.out.println(orderService.processOrder("ORD-001"));

        System.out.println("Prometheus metrics available at GET /metrics");
    }
}

