/**
 * OTP (TOTP/HOTP) authentication example.
 * <p>
 * Configures Time-based One-Time Password (TOTP) authentication with a 6-digit code
 * and 30-second period. Requires an {@code IOtpAuthenticatorService} SPI implementation
 * for storing and retrieving authenticator state.
 */
@OtpAuthOptions(
    type = OtpType.TOTP,
    passwordLength = 6,
    period = 30
)
package com.guicedee.examples.auth.otp;

import com.guicedee.vertx.auth.otp.OtpAuthOptions;
import com.guicedee.vertx.auth.otp.OtpType;

