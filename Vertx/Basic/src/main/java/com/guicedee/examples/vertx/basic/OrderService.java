package com.guicedee.examples.vertx.basic;

import com.guicedee.vertx.VertxEventPublisher;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Demonstrates injecting VertxEventPublisher to send messages on the event bus.
 * <p>
 * Publisher methods:
 * <ul>
 *   <li>{@code request(body)} — request/reply, returns Future&lt;R&gt;</li>
 *   <li>{@code send(body)} — point-to-point fire-and-forget (throttled)</li>
 *   <li>{@code publish(body)} — broadcast to all consumers (throttled)</li>
 *   <li>{@code publishLocal(body)} — local-only broadcast</li>
 * </ul>
 */
public class OrderService
{
    @Inject
    @Named("order.created")
    private VertxEventPublisher<OrderRequest> orderCreatedPublisher;

    @Inject
    @Named("order.completed")
    private VertxEventPublisher<String> orderCompletedPublisher;

    @Inject
    @Named("order.cancelled")
    private VertxEventPublisher<String> orderCancelledPublisher;

    /**
     * Creates an order via request/reply — waits for consumer confirmation.
     */
    public void createOrder(String id, String item, double amount)
    {
        OrderRequest order = new OrderRequest(id, item, amount);
        orderCreatedPublisher.request(order)
                .onComplete(ar ->
                {
                    if (ar.succeeded())
                    {
                        System.out.println("[OrderService] Reply: " + ar.result().body());
                    }
                    else
                    {
                        System.err.println("[OrderService] Error: " + ar.cause().getMessage());
                    }
                });
    }

    /**
     * Marks an order as complete — fire-and-forget broadcast.
     */
    public void completeOrder(String orderId)
    {
        orderCompletedPublisher.publish(orderId);
        System.out.println("[OrderService] Published order.completed for: " + orderId);
    }

    /**
     * Cancels an order via point-to-point send.
     */
    public void cancelOrder(String orderId)
    {
        orderCancelledPublisher.send(orderId);
        System.out.println("[OrderService] Sent order.cancelled for: " + orderId);
    }
}

