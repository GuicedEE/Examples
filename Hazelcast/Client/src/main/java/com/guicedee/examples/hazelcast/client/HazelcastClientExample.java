package com.guicedee.examples.hazelcast.client;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedhazelcast.HazelcastClientOptions;
import com.guicedee.guicedhazelcast.services.HazelcastClientPreStartup;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates a Hazelcast client node connecting to a remote Hazelcast cluster.
 * Requires a running Hazelcast server (see HazelcastServerExample).
 */
@HazelcastClientOptions(
        clusterName = "dev",
        addresses = "localhost:5701"
)
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

        // Read from the distributed map populated by the server
        HazelcastInstance hz = HazelcastClientPreStartup.getClientInstance();
        IMap<String, String> map = hz.getMap("example-map");
        System.out.println("Read from map: " + map.get("greeting"));
        System.out.println("Map size: " + map.size());
    }
}
