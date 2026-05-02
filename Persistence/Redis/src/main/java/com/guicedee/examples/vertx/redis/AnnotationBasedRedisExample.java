package com.guicedee.examples.vertx.redis;

import com.guicedee.vertx.redis.RedisOptions;

/**
 * Annotation-based Redis configuration example.
 * <p>
 * This is the simplest way to configure Redis — just annotate a class
 * and the connection is auto-discovered at startup.
 * <p>
 * All values support {@code ${ENV_VAR:default}} placeholder syntax.
 */
@RedisOptions(
        name = "annotated-cache",
        connectionString = "${REDIS_URL:redis://localhost:6379/0}",
        maxPoolSize = 8,
        maxWaitingHandlers = 32,
        defaultConnection = true
)
public class AnnotationBasedRedisExample {
    // No code needed — the @RedisOptions annotation is auto-discovered
    // by RedisPreStartup and a Redis client is created and bound in Guice.
    //
    // Inject anywhere:
    //   @Inject Redis redis;
    //   @Inject RedisAPI redisAPI;
    //   @Inject @Named("annotated-cache") Redis namedRedis;
}

