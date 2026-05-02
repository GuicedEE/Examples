package com.guicedee.examples.vertx.redis;

import com.guicedee.vertx.redis.RedisConnectionInfo;
import com.guicedee.vertx.redis.RedisModule;

/**
 * Example Redis module that connects to a local Redis instance.
 * <p>
 * Configuration is driven by environment variables:
 * <ul>
 *   <li>REDIS_HOST — Redis server host (default: localhost)</li>
 *   <li>REDIS_PORT — Redis server port (default: 6379)</li>
 *   <li>REDIS_DATABASE — Database number (default: 0)</li>
 *   <li>REDIS_PASSWORD — Password (optional)</li>
 *   <li>REDIS_MAX_POOL — Max pool size (default: 8)</li>
 * </ul>
 */
public class ExampleRedisModule extends RedisModule<ExampleRedisModule> {

    @Override
    protected RedisConnectionInfo getRedisConnectionInfo() {
        String host = System.getProperty("REDIS_HOST",
                System.getenv().getOrDefault("REDIS_HOST", "localhost"));
        int port = Integer.parseInt(System.getProperty("REDIS_PORT",
                System.getenv().getOrDefault("REDIS_PORT", "6379")));
        int database = Integer.parseInt(System.getProperty("REDIS_DATABASE",
                System.getenv().getOrDefault("REDIS_DATABASE", "0")));
        String password = System.getProperty("REDIS_PASSWORD",
                System.getenv().get("REDIS_PASSWORD"));
        int maxPool = Integer.parseInt(System.getProperty("REDIS_MAX_POOL",
                System.getenv().getOrDefault("REDIS_MAX_POOL", "8")));

        RedisConnectionInfo info = new RedisConnectionInfo()
                .setName("example-redis")
                .setConnectionString("redis://" + host + ":" + port + "/" + database)
                .setMaxPoolSize(maxPool)
                .setMaxWaitingHandlers(32)
                .setDefaultConnection(true);

        if (password != null && !password.isBlank()) {
            info.setPassword(password);
        }

        return info;
    }
}

