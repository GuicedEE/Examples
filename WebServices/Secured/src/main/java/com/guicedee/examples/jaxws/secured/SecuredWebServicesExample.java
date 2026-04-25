package com.guicedee.examples.jaxws.secured;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates a secured SOAP web service with WS-Security support.
 */
public class SecuredWebServicesExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.jaxws.secured");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Secured WebServices example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

