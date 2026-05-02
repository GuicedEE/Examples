package com.guicedee.examples.auth.otp;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates OTP (TOTP) authentication with GuicedEE.
 * <p>
 * OTP requires an {@code IOtpAuthenticatorService} SPI for storage —
 * see {@link InMemoryOtpService} for the example implementation.
 * <p>
 * In production, use a database-backed implementation and register users
 * with a QR code enrollment flow.
 */
public class OtpAuthExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.auth.otp");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("OTP Auth example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}

