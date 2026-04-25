package com.guicedee.examples.hazelcast.client;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates a Hazelcast client node connecting to a Hazelcast-clustered Vert.x cluster.
 */
public class HazelcastClientExample
{
    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.hazelcast.client");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Hazelcast client example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

