package com.guicedee.examples.jaxws.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates a SOAP web service using JAX-WS annotations with GuicedEE.
 * The HelloService endpoint is published during IGuicePostStartup.
 */
public class WebServicesExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.jaxws.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("WebServices example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
        System.out.println("SOAP endpoint available for HelloService");
    }
}

