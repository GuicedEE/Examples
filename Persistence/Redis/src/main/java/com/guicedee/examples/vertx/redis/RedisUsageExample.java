package com.guicedee.examples.vertx.redis;

import com.google.inject.Inject;
import com.guicedee.client.IGuiceContext;
import io.vertx.redis.client.Redis;
import io.vertx.redis.client.RedisAPI;
import io.vertx.redis.client.Request;
import io.vertx.redis.client.Command;
import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Demonstrates using the injected Redis client for common operations.
 * <p>
 * This example shows:
 * <ul>
 *   <li>String GET/SET operations via RedisAPI</li>
 *   <li>Hash operations (HSET/HGET/HGETALL)</li>
 *   <li>List operations (LPUSH/LRANGE)</li>
 *   <li>Pub/Sub messaging</li>
 *   <li>Key expiration (EXPIRE/TTL)</li>
 * </ul>
 */
@Log4j2
public class RedisUsageExample {

    @Inject
    private RedisAPI redis;

    @Inject
    private Redis redisClient;

    /**
     * Basic string SET/GET.
     */
    public void stringOperations() {
        redis.set(List.of("user:1:name", "Alice"))
                .onSuccess(res -> log.info("SET user:1:name = Alice"))
                .onFailure(err -> log.error("SET failed", err));

        redis.get("user:1:name")
                .onSuccess(value -> log.info("GET user:1:name = {}", value))
                .onFailure(err -> log.error("GET failed", err));

        // SET with expiration (EX = seconds)
        redis.set(List.of("session:abc123", "active", "EX", "3600"))
                .onSuccess(res -> log.info("SET session with 1h TTL"));
    }

    /**
     * Hash operations for structured data.
     */
    public void hashOperations() {
        // HSET user:1 field value [field value ...]
        redis.hset(List.of("user:1", "name", "Alice", "email", "alice@example.com", "age", "30"))
                .onSuccess(res -> log.info("HSET user:1 — {} fields added", res))
                .onFailure(err -> log.error("HSET failed", err));

        // HGET single field
        redis.hget("user:1", "email")
                .onSuccess(value -> log.info("HGET user:1 email = {}", value));

        // HGETALL — all fields and values
        redis.hgetall("user:1")
                .onSuccess(response -> {
                    log.info("HGETALL user:1:");
                    for (int i = 0; i < response.size(); i += 2) {
                        log.info("  {} = {}", response.get(i), response.get(i + 1));
                    }
                });
    }

    /**
     * List operations.
     */
    public void listOperations() {
        // LPUSH — add to the front of a list
        redis.lpush(List.of("notifications:user1", "New message from Bob"))
                .onSuccess(res -> log.info("LPUSH notifications — list length: {}", res));

        // LRANGE — retrieve a range of elements
        redis.lrange("notifications:user1", "0", "-1")
                .onSuccess(items -> {
                    log.info("Notifications for user1:");
                    for (var item : items) {
                        log.info("  • {}", item);
                    }
                });
    }

    /**
     * Pub/Sub messaging.
     */
    public void pubSubExample() {
        // Subscribe to a channel using a separate connection
        redisClient.connect()
                .onSuccess(conn -> {
                    conn.handler(message -> {
                        log.info("📩 Received pub/sub message: {}", message);
                    });
                    conn.send(Request.cmd(Command.SUBSCRIBE).arg("events"))
                            .onSuccess(res -> log.info("✅ Subscribed to 'events' channel"));
                });

        // Publish to the channel (from the pooled client)
        redis.publish("events", "Hello from GuicedEE Redis!")
                .onSuccess(res -> log.info("Published message to {} subscriber(s)", res));
    }

    /**
     * Key expiration and TTL.
     */
    public void expirationExample() {
        redis.set(List.of("temp:data", "will expire"))
                .compose(v -> redis.expire(List.of("temp:data", "60")))
                .onSuccess(res -> log.info("Key temp:data expires in 60 seconds"));

        redis.ttl("temp:data")
                .onSuccess(ttl -> log.info("TTL for temp:data = {} seconds", ttl));
    }

    /**
     * Increment counters (atomic operations).
     */
    public void counterExample() {
        redis.incr("page:views:home")
                .onSuccess(newVal -> log.info("Page views for home: {}", newVal));

        redis.incrby("page:views:home", "10")
                .onSuccess(newVal -> log.info("Page views after +10: {}", newVal));
    }
}

