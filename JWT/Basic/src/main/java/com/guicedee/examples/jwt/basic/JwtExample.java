package com.guicedee.examples.jwt.basic;

import com.guicedee.client.IGuiceContext;
import com.guicedee.microprofile.jwt.MicroProfileJwtContext;
import com.guicedee.microprofile.jwt.VertxJsonWebToken;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.PubSecKeyOptions;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Demonstrates the MicroProfile JWT bridge with Vert.x JWTAuth.
 * <p>
 * This example:
 * <ol>
 *   <li>Creates a Vert.x JWTAuth provider with HMAC signing</li>
 *   <li>Generates and verifies a JWT token</li>
 *   <li>Bridges the Vert.x User to a MicroProfile JsonWebToken</li>
 *   <li>Sets the JWT in the request context</li>
 *   <li>Reads claims from the JsonWebToken API</li>
 * </ol>
 */
public class JwtExample
{
    private static final String SECRET = "super-secret-key-for-testing-only-must-be-at-least-256-bits!";

    public static void main(String[] args) throws Exception
    {
        LocalDateTime startTime = LocalDateTime.now();

        // 1. Create Vert.x and JWTAuth
        Vertx vertx = Vertx.vertx();
        JWTAuth jwtAuth = JWTAuth.create(vertx, new JWTAuthOptions()
                .addPubSecKey(new PubSecKeyOptions()
                        .setAlgorithm("HS256")
                        .setBuffer(SECRET)));

        // 2. Generate a signed JWT
        String token = jwtAuth.generateToken(
                new JsonObject()
                        .put("sub", "user-42")
                        .put("iss", "https://example.guicedee.com")
                        .put("upn", "alice@guicedee.com")
                        .put("preferred_username", "alice")
                        .put("email_verified", true)
                        .put("groups", new JsonArray().add("admin").add("developer")),
                new JWTOptions()
                        .setExpiresInSeconds(3600)
                        .setAudience(java.util.List.of("my-api"))
        );

        System.out.println("Generated JWT token (length=" + token.length() + ")");

        // 3. Verify the token
        User user = authenticate(jwtAuth, token);
        System.out.println("Token verified successfully");

        // 4. Bridge to MicroProfile JWT
        VertxJsonWebToken jwt = new VertxJsonWebToken(user);
        MicroProfileJwtContext.setCurrent(jwt);

        System.out.println();
        System.out.println("=== MicroProfile JWT Claims ===");
        System.out.println("Name:       " + jwt.getName());
        System.out.println("Subject:    " + jwt.getSubject());
        System.out.println("Issuer:     " + jwt.getIssuer());
        System.out.println("Token ID:   " + jwt.getTokenID());
        System.out.println("Groups:     " + jwt.getGroups());
        System.out.println("Audience:   " + jwt.getAudience());
        System.out.println("Expires:    " + jwt.getExpirationTime());
        System.out.println("Issued At:  " + jwt.getIssuedAtTime());
        System.out.println("All Claims: " + jwt.getClaimNames());

        // 5. Retrieve from context (simulating a request handler)
        JsonWebToken current = MicroProfileJwtContext.getCurrent();
        System.out.println();
        System.out.println("=== From MicroProfileJwtContext ===");
        System.out.println("Subject: " + current.getSubject());
        System.out.println("Name:    " + current.getName());

        // 6. Clean up
        MicroProfileJwtContext.clear();

        CountDownLatch latch = new CountDownLatch(1);
        vertx.close().onComplete(ar -> latch.countDown());
        latch.await(5, TimeUnit.SECONDS);

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println();
        System.out.println("Completed in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }

    private static User authenticate(JWTAuth jwtAuth, String token) throws Exception
    {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<User> userRef = new AtomicReference<>();
        AtomicReference<Throwable> errorRef = new AtomicReference<>();

        jwtAuth.authenticate(new TokenCredentials(token))
                .onSuccess(u -> {
                    userRef.set(u);
                    latch.countDown();
                })
                .onFailure(t -> {
                    errorRef.set(t);
                    latch.countDown();
                });

        if (!latch.await(5, TimeUnit.SECONDS))
        {
            throw new RuntimeException("Authentication timed out");
        }
        if (errorRef.get() != null)
        {
            throw new RuntimeException("Authentication failed", errorRef.get());
        }
        return userRef.get();
    }
}

