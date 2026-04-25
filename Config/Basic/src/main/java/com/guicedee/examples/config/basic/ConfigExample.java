package com.guicedee.examples.config.basic;

import com.guicedee.client.IGuiceContext;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates MicroProfile Config injection with @ConfigProperty.
 * Values are resolved from META-INF/microprofile-config.properties,
 * system properties, and environment variables.
 */
public class ConfigExample
{
    @ConfigProperty(name = "app.greeting", defaultValue = "Hello")
    private String greeting;

    @ConfigProperty(name = "app.name", defaultValue = "GuicedEE")
    private String appName;

    @ConfigProperty(name = "app.port", defaultValue = "8080")
    private int port;

    public void printConfig()
    {
        System.out.println(greeting + " from " + appName + " on port " + port);
    }

    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.config.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        ConfigExample example = IGuiceContext.get(ConfigExample.class);
        example.printConfig();

        IGuiceContext.instance()
                .destroy();
    }
}

