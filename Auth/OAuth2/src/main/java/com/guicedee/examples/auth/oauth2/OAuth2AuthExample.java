package com.guicedee.examples.auth.oauth2;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates OAuth2/OIDC authentication with GuicedEE.
 * <p>
 * Configure your OAuth2 provider credentials via environment variables:
 * <pre>
 * export OAUTH2_CLIENT_ID=your-client-id
 * export OAUTH2_CLIENT_SECRET=your-client-secret
 * export OAUTH2_SITE=https://accounts.google.com
 * </pre>
 * <p>
 * The callback URL will be available at {@code http://localhost:8080/callback}.
 */
public class OAuth2AuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.auth.oauth2");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("OAuth2 Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

