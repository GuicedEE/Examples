package com.guicedee.examples.hazelcast.queues;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedhazelcast.HazelcastServerOptions;
import com.guicedee.guicedhazelcast.services.HazelcastPreStartup;
import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Hazelcast distributed queues with GuicedEE.
 * Starts an embedded instance and performs queue offer/poll operations.
 */
@HazelcastServerOptions(
        clusterName = "dev",
        startLocal = true,
        joinType = HazelcastServerOptions.JoinType.NONE
)
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

        // Demonstrate distributed queue usage
        HazelcastInstance hz = HazelcastPreStartup.getInstance();
        IQueue<String> queue = hz.getQueue("example-queue");

        // Offer items
        queue.offer("Task-1");
        queue.offer("Task-2");
        queue.offer("Task-3");
        System.out.println("Queue size after offers: " + queue.size());

        // Poll items
        String item;
        while ((item = queue.poll()) != null)
        {
            System.out.println("Polled: " + item);
        }
        System.out.println("Queue size after polling: " + queue.size());
    }
}
