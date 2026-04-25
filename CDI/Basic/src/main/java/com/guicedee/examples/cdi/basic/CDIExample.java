package com.guicedee.examples.cdi.basic;

import com.guicedee.client.IGuiceContext;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates using Jakarta CDI annotations (@ApplicationScoped, @Inject)
 * with the GuicedEE CDI bridge. CDI annotations are mapped to their Guice equivalents.
 */
public class CDIExample
{
    @Inject
    private GreetingService greetingService;

    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.cdi.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        CDIExample example = IGuiceContext.get(CDIExample.class);
        System.out.println(example.greetingService.greet("World"));

        IGuiceContext.instance()
                .destroy();
    }
}

