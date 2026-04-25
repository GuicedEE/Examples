package com.guicedee.examples.hazelcast.queues;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Hazelcast distributed queues with Vert.x event bus.
 */
public class HazelcastQueuesExample
{
    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.hazelcast.queues");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Hazelcast queues example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

