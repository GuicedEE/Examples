package com.guicedee.examples.openapi.swaggerui;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.GuiceApplication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates OpenAPI with Swagger UI. After bootstrap:
 * <ul>
 *   <li>GET /swagger/ — Browsable Swagger UI</li>
 *   <li>GET /openapi.json — OpenAPI spec</li>
 * </ul>
 */
public class SwaggerUIExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        GuiceApplication.run(() -> {
            IGuiceContext.registerModule("com.guicedee.examples.openapi.swaggerui");
            IGuiceContext.getContext().getConfig().setServiceLoadWithClassPath(true);
        });

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Swagger UI example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
        System.out.println("Swagger UI available at /swagger/");
    }
}

