package com.guicedee.examples.vertx.redis;

import com.guicedee.vertx.redis.RedisOptions;

/**
 * Example of TLS-secured Redis connection via annotation.
 * <p>
 * TLS configuration supports PEM certificates with hostname verification.
 */
@RedisOptions(
        name = "secure-redis",
        connectionString = "${REDIS_SECURE_URL:redis://secure-host:6380/0}",
        password = "${REDIS_SECURE_PASSWORD:}",
        tlsEnabled = true,
        tlsCertPath = "${REDIS_TLS_CERT:/certs/redis-ca.crt}",
        tlsVerifyHost = "HTTPS",
        protocol = RedisOptions.Protocol.RESP3,
        maxPoolSize = 4,
        defaultConnection = false
)
public class TlsRedisExample {
    // Inject with: @Inject @Named("secure-redis") Redis redis;
}

