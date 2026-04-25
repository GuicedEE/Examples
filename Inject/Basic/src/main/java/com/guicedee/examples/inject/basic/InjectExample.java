package com.guicedee.examples.inject.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates bootstrapping the GuicedEE DI container with lifecycle hooks.
 * <p>
 * Shows: IGuiceModule for Guice bindings, IGuicePostStartup for post-startup logic,
 * and @Inject for dependency injection.
 */
public class InjectExample
{
    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.inject.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        // Retrieve a bound instance via the injector
        Greeter greeter = IGuiceContext.get(Greeter.class);
        System.out.println(greeter.greet("World"));

        IGuiceContext.instance()
                .destroy();
    }
}

