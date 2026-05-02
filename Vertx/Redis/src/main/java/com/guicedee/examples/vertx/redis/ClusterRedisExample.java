package com.guicedee.examples.vertx.redis;

import com.guicedee.vertx.redis.RedisOptions;

/**
 * Example of annotation-based Redis Cluster configuration.
 * <p>
 * In cluster mode, the client discovers the full topology from the initial nodes
 * and routes commands to the correct shard based on the key hash slot.
 */
@RedisOptions(
        name = "cluster-redis",
        mode = RedisOptions.Mode.CLUSTER,
        connectionString = "${REDIS_CLUSTER_NODE_1:redis://node1:7000}",
        endpoints = {
                "${REDIS_CLUSTER_NODE_2:redis://node2:7001}",
                "${REDIS_CLUSTER_NODE_3:redis://node3:7002}",
                "${REDIS_CLUSTER_NODE_4:redis://node4:7003}",
                "${REDIS_CLUSTER_NODE_5:redis://node5:7004}",
                "${REDIS_CLUSTER_NODE_6:redis://node6:7005}"
        },
        maxPoolSize = 8,
        defaultConnection = false
)
public class ClusterRedisExample {
    // Inject with: @Inject @Named("cluster-redis") Redis redis;
}

