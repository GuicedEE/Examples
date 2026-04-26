/**
 * Auth configuration — JWT authentication + property-file authorization.
 * <p>
 * JWT tokens are signed with HS256 using the keystore at {@code auth-keystore.jceks}.
 * Roles and permissions are loaded from {@code auth.properties} (Shiro format).
 * <p>
 * Override at deploy time:
 * <ul>
 *   <li>{@code VERTX_AUTH_JWT_KEYSTORE_PASSWORD=changeit}</li>
 *   <li>{@code VERTX_AUTH_PROPERTIES_PATH=prod-auth.properties}</li>
 * </ul>
 */
@JwtAuthOptions(
        keystorePath = "auth-keystore.jceks",
        keystoreType = "jceks",
        keystorePassword = "${JWT_KEYSTORE_PASSWORD}",
        algorithm = "HS256",
        issuer = "vertx-auth-example",
        expiresInSeconds = 3600
)
@PropertyFileAuthOptions(path = "auth.properties")
package com.guicedee.examples.vertx.auth;

import com.guicedee.vertx.auth.jwt.JwtAuthOptions;
import com.guicedee.vertx.auth.properties.PropertyFileAuthOptions;

