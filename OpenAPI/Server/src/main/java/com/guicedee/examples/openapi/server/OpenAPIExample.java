package com.guicedee.examples.openapi.server;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates automatic OpenAPI 3.1 spec generation from Jakarta REST resources.
 * After bootstrap, endpoints available:
 * <ul>
 *   <li>GET /openapi.json — OpenAPI spec in JSON</li>
 *   <li>GET /openapi.yaml — OpenAPI spec in YAML</li>
 *   <li>GET /rest/users — List users</li>
 *   <li>GET /rest/users/{id} — Get user by ID</li>
 * </ul>
 */
public class OpenAPIExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.openapi.server");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("OpenAPI example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
        System.out.println("OpenAPI spec available at /openapi.json and /openapi.yaml");
    }
}

