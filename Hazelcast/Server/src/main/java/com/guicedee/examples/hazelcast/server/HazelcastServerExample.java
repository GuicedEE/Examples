package com.guicedee.examples.hazelcast.server;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates a Hazelcast-clustered Vert.x server with GuicedEE.
 * Configure clustering via @VertX annotation or hazelcast.xml on the classpath.
 */
public class HazelcastServerExample
{
    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.hazelcast.server");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Hazelcast server example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

