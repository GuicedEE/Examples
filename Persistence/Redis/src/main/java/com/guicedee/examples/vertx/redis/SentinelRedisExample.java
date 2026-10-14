package com.guicedee.examples.vertx.redis;

import com.guicedee.client.Environment;

import com.guicedee.vertx.redis.RedisConnectionInfo;
import com.guicedee.vertx.redis.RedisModule;

/**
 * Example Redis Sentinel module for high-availability setups.
 * <p>
 * Redis Sentinel provides automatic failover — when the master goes down,
 * Sentinel promotes a replica to master and the client transparently reconnects.
 *
 * <h3>Environment Variables</h3>
 * <ul>
 *   <li>{@code REDIS_SENTINEL_1} — First sentinel node (default: redis://sentinel1:5000)</li>
 *   <li>{@code REDIS_SENTINEL_2} — Second sentinel node (default: redis://sentinel2:5000)</li>
 *   <li>{@code REDIS_SENTINEL_3} — Third sentinel node (default: redis://sentinel3:5000)</li>
 *   <li>{@code REDIS_MASTER_NAME} — Master name (default: mymaster)</li>
 * </ul>
 */
public class SentinelRedisExample extends RedisModule<SentinelRedisExample> {

    @Override
    protected RedisConnectionInfo getRedisConnectionInfo() {
        return new RedisConnectionInfo()
                .setName("sentinel-redis")
                .setRedisMode(RedisConnectionInfo.RedisMode.SENTINEL)
                .setConnectionString(Environment.getSystemPropertyOrEnvironment("REDIS_SENTINEL_1", "redis://sentinel1:5000"))
                .addEndpoint(Environment.getSystemPropertyOrEnvironment("REDIS_SENTINEL_2", "redis://sentinel2:5000"))
                .addEndpoint(Environment.getSystemPropertyOrEnvironment("REDIS_SENTINEL_3", "redis://sentinel3:5000"))
                .setMasterName(Environment.getSystemPropertyOrEnvironment("REDIS_MASTER_NAME", "mymaster"))
                .setMaxPoolSize(6)
                .setDefaultConnection(false);
    }

}

