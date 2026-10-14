package com.guicedee.examples.auth.ldap;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.GuiceApplication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates LDAP authentication with GuicedEE.
 * <p>
 * Requires a running LDAP server. Configure via environment variables:
 * <pre>
 * export LDAP_URL=ldap://localhost:389
 * </pre>
 * <p>
 * The authentication query binds as {@code uid={username},ou=users,dc=example,dc=com}.
 */
public class LdapAuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        GuiceApplication.run(() -> {
            IGuiceContext.registerModule("com.guicedee.examples.auth.ldap");
            IGuiceContext.getContext().getConfig().setServiceLoadWithClassPath(true);
        });

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("LDAP Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

