package com.guicedee.examples.vertx.auth;

import com.guicedee.client.IGuiceContext;

/**
 * Entry point for the Vert.x Auth example.
 * <p>
 * Demonstrates JWT authentication + property-file authorization
 * with a protected REST endpoint.
 * <p>
 * <strong>To test:</strong>
 * <ol>
 *   <li>POST /api/auth/login with {"username":"tim","password":"mypassword"} → returns JWT token</li>
 *   <li>GET /api/auth/protected with header "Authorization: Bearer &lt;token&gt;" → returns user info</li>
 *   <li>GET /api/auth/admin with header "Authorization: Bearer &lt;token&gt;" → admin-only endpoint</li>
 * </ol>
 */
public class AuthExample
{
    public static void main(String[] args)
    {
        IGuiceContext.instance().inject();
        System.out.println("Auth example running on http://localhost:8080");
        System.out.println("  POST /api/auth/login   — get JWT token");
        System.out.println("  GET  /api/auth/me       — protected (any authenticated user)");
        System.out.println("  GET  /api/auth/admin    — admin only (@RolesAllowed)");
    }
}

