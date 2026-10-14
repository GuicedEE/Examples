package com.guicedee.examples.mailclient;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.GuiceApplication;
import com.guicedee.mailclient.MailConnectionOptions;
import com.guicedee.mailclient.MailService;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates sending email via GuicedEE MailClient.
 * <p>
 * Uses {@code @MailConnectionOptions} to configure the SMTP connection.
 * For local testing, use a test SMTP server such as MailHog (port 1025)
 * or Greenmail.
 */
@MailConnectionOptions(
        hostname = "localhost",
        port = 1025,
        login = MailConnectionOptions.LoginMode.NONE,
        startTls = MailConnectionOptions.StartTLSMode.DISABLED,
        defaultFrom = "noreply@example.com"
)
public class MailClientExample
{
    @Inject
    @Named("default")
    private MailService mailService;

    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        GuiceApplication.run(() -> {
            IGuiceContext.registerModule("com.guicedee.examples.mailclient");
            IGuiceContext.getContext().getConfig().setServiceLoadWithClassPath(true);
        });

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Mail client example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        // Get the example instance from Guice to use the injected MailService
        MailClientExample example = IGuiceContext.get(MailClientExample.class);
        example.sendSampleEmail();
    }

    private void sendSampleEmail()
    {
        mailService.sendText(
                        "recipient@example.com",
                        "Hello from GuicedEE",
                        "This is a test email sent via GuicedEE MailClient with Vert.x.")
                .onSuccess(result -> System.out.println("Email sent! MessageID: " + result.getMessageID()))
                .onFailure(err -> System.err.println("Failed to send email: " + err.getMessage()));
    }
}

