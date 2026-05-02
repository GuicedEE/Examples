/**
 * OAuth2/OIDC authentication example.
 * <p>
 * Configures Vert.x OAuth2Auth with Authorization Code flow.
 * Set environment variables for your OAuth2 provider:
 * <ul>
 *   <li>{@code VERTX_AUTH_OAUTH2_CLIENT_ID}</li>
 *   <li>{@code VERTX_AUTH_OAUTH2_CLIENT_SECRET}</li>
 *   <li>{@code VERTX_AUTH_OAUTH2_SITE}</li>
 *   <li>{@code VERTX_AUTH_OAUTH2_DISCOVERY_URL}</li>
 * </ul>
 */
@OAuth2Options(
    flow = OAuth2Options.FlowType.AUTH_CODE,
    clientId = "${OAUTH2_CLIENT_ID:my-client-id}",
    clientSecret = "${OAUTH2_CLIENT_SECRET:my-client-secret}",
    site = "${OAUTH2_SITE:https://accounts.google.com}",
    tokenPath = "/o/oauth2/token",
    authorizationPath = "/o/oauth2/auth",
    discoveryUrl = "${OAUTH2_DISCOVERY_URL:}",
    callbackPath = "/callback"
)
package com.guicedee.examples.auth.oauth2;

import com.guicedee.vertx.auth.oauth2.OAuth2Options;

