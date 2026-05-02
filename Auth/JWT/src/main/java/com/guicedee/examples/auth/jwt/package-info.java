/**
 * JWT authentication example.
 * <p>
 * Configures Vert.x JWTAuth with HMAC signing via {@code @JwtAuthOptions}.
 * The keystore password and algorithm can be overridden with environment variables.
 */
@JwtAuthOptions(
    keystorePath = "keystore.jceks",
    keystoreType = "jceks",
    keystorePassword = "${JWT_KEYSTORE_PASSWORD:secret}",
    algorithm = "HS256",
    issuer = "guicedee-example",
    audience = {"my-api"},
    expiresInSeconds = 3600,
    authorizationType = JwtAuthorizationType.MICROPROFILE
)
package com.guicedee.examples.auth.jwt;

import com.guicedee.vertx.auth.jwt.JwtAuthOptions;
import com.guicedee.vertx.auth.jwt.JwtAuthorizationType;

