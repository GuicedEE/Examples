package com.guicedee.examples.web.basic;

import com.guicedee.vertx.web.spi.VertxRouterConfigurator;
import io.vertx.ext.web.Router;

/**
 * Custom route configurator using the VertxRouterConfigurator SPI.
 * Adds custom routes to the Vert.x Router during startup.
 */
public class CustomRouteConfigurator implements VertxRouterConfigurator<CustomRouteConfigurator>
{
    @Override
    public Router builder(Router router)
    {
        router.get("/hello").handler(ctx ->
                ctx.response()
                        .putHeader("content-type", "text/plain")
                        .end("Hello from GuicedEE Vert.x Web!"));

        router.get("/status").handler(ctx ->
                ctx.response()
                        .putHeader("content-type", "application/json")
                        .end("{\"status\":\"ok\"}"));

        return router;
    }
}

