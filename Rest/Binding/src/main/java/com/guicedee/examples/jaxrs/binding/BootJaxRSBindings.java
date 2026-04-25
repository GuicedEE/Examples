package com.guicedee.examples.jaxrs.binding;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BootJaxRSBindings
{
    public static void main(String... args) throws Exception
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.jaxrs.binding");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}
