package com.guicedee.examples.web.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates the Vert.x Web server with custom routes via VertxRouterConfigurator SPI.
 * After bootstrap, endpoints available:
 * <ul>
 *   <li>GET /hello — plain text greeting</li>
 *   <li>GET /status — JSON status</li>
 * </ul>
 */
public class WebExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.web.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Web example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
        System.out.println("HTTP server ready — try GET /hello and GET /status");
    }
}

