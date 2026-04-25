package com.guicedee.examples.vertx.basic;

import com.guicedee.client.IGuiceContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Vert.x event bus messaging with GuicedEE:
 * <ul>
 *   <li>Method-based consumers via @VertxEventDefinition (see {@link OrderConsumers})</li>
 *   <li>Worker threads via @VertxEventOptions(worker = true)</li>
 *   <li>Publisher injection via @Named VertxEventPublisher (see {@link OrderService})</li>
 *   <li>Request/reply, send (point-to-point), and publish (broadcast) patterns</li>
 *   <li>POJO serialization via Jackson (see {@link OrderRequest})</li>
 * </ul>
 * Vert.x starts automatically via SPI — never create Vertx manually.
 */
public class VertxExample
{
    public static void main(String[] args) throws InterruptedException
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.vertx.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Vert.x example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        // Get the Guice-managed OrderService with injected publishers
        OrderService orderService = IGuiceContext.get(OrderService.class);

        // request/reply — consumer returns "Accepted: ORD-001"
        orderService.createOrder("ORD-001", "Widget", 29.99);

        // broadcast — all consumers of order.completed receive the message
        orderService.completeOrder("ORD-001");

        // point-to-point — one consumer of order.cancelled handles the message
        orderService.cancelOrder("ORD-002");

        // Give the async event bus time to process
        Thread.sleep(1000);
        System.out.println("Event bus demo complete.");
    }
}
