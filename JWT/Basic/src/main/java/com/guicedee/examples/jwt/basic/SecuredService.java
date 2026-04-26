package com.guicedee.examples.jwt.basic;

import org.eclipse.microprofile.jwt.Claim;

import java.util.Set;

/**
 * Demonstrates @Claim injection for JWT claims.
 * <p>
 * Fields annotated with @Claim are automatically injected by GuicedEE
 * without needing @Inject — the SPI registration handles it.
 */
public class SecuredService
{
    @Claim("sub")
    private String subject;

    @Claim("preferred_username")
    private String username;

    @Claim("groups")
    private Set<String> roles;

    @Claim("exp")
    private Long expiration;

    @Claim("email_verified")
    private Boolean emailVerified;

    public String getSubject()
    {
        return subject;
    }

    public String getUsername()
    {
        return username;
    }

    public Set<String> getRoles()
    {
        return roles;
    }

    public Long getExpiration()
    {
        return expiration;
    }

    public Boolean isEmailVerified()
    {
        return emailVerified;
    }

    public void printClaims()
    {
        System.out.println("Subject:        " + subject);
        System.out.println("Username:       " + username);
        System.out.println("Roles:          " + roles);
        System.out.println("Expiration:     " + expiration);
        System.out.println("Email Verified: " + emailVerified);
    }
}

