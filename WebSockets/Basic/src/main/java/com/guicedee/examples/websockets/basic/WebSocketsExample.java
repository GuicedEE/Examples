package com.guicedee.examples.websockets.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates WebSocket messaging with action-based routing via IWebSocketMessageReceiver.
 * WebSocket server starts automatically on bootstrap.
 * Send JSON: {"action": "chat", "data": {"text": "Hello!"}}
 */
public class WebSocketsExample
{
    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.websockets.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("WebSocket example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
        System.out.println("WebSocket server ready — connect and send {\"action\":\"chat\",\"data\":{\"text\":\"Hello!\"}}");
    }
}

