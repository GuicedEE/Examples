package com.guicedee.examples.auth.otp;

import com.guicedee.vertx.auth.otp.IOtpAuthenticatorService;
import io.smallrye.mutiny.Uni;
import io.vertx.ext.auth.otp.Authenticator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory OTP authenticator storage for demonstration purposes.
 * <p>
 * In production, replace this with a database-backed implementation.
 * This SPI is required — OTP auth will not work without it.
 */
public class InMemoryOtpService implements IOtpAuthenticatorService
{
    private final Map<String, Authenticator> store = new ConcurrentHashMap<>();

    @Override
    public Uni<Authenticator> fetch(String id)
    {
        Authenticator auth = store.get(id);
        return auth != null ? Uni.createFrom().item(auth) : Uni.createFrom().nullItem();
    }

    @Override
    public Uni<Void> store(String id, Authenticator authenticator)
    {
        store.put(id, authenticator);
        return Uni.createFrom().voidItem();
    }
}

