package com.guicedee.examples.hazelcast.server;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedhazelcast.HazelcastServerOptions;
import com.guicedee.guicedhazelcast.services.HazelcastPreStartup;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates a Hazelcast-clustered Vert.x server with GuicedEE.
 * Starts an embedded Hazelcast instance with multicast discovery disabled (standalone).
 */
@HazelcastServerOptions(
        clusterName = "dev",
        startLocal = true,
        joinType = HazelcastServerOptions.JoinType.NONE
)
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

        // Demonstrate distributed map usage
        HazelcastInstance hz = HazelcastPreStartup.getInstance();
        IMap<String, String> map = hz.getMap("example-map");
        map.put("greeting", "Hello from Hazelcast!");
        System.out.println("Stored in map: " + map.get("greeting"));
        System.out.println("Map size: " + map.size());
    }
}
