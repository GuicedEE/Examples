package com.guicedee.examples.auth.otp;

import com.guicedee.vertx.auth.otp.IOtpAuthenticatorService;
import io.vertx.core.Future;
import io.vertx.ext.auth.otp.Authenticator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

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
    public Function<String, Future<Authenticator>> authenticatorFetcher()
    {
        return id -> Future.succeededFuture(store.get(id));
    }

    @Override
    public Function<Authenticator, Future<Void>> authenticatorUpdater()
    {
        return authenticator -> {
            store.put(authenticator.getIdentifier(), authenticator);
            return Future.succeededFuture();
        };
    }
}

