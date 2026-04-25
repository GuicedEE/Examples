package com.guicedee.examples.vertx.basic;

import com.guicedee.vertx.VertxEventDefinition;
import com.guicedee.vertx.VertxEventOptions;
import io.vertx.core.eventbus.Message;

/**
 * Event bus consumers using method-based @VertxEventDefinition.
 * One EventConsumerVerticle is deployed per address automatically.
 * <p>
 * Supports: void, value, Uni&lt;T&gt;, or Future&lt;T&gt; return types.
 * Use Message&lt;T&gt; parameter for raw access, or a POJO parameter for Jackson deserialization.
 */
public class OrderConsumers
{
    /**
     * Handles new order creation. Runs on a worker thread (blocking-safe).
     * Returns a reply string to the sender.
     */
    @VertxEventDefinition(value = "order.created",
            options = @VertxEventOptions(worker = true))
    public String handleOrderCreated(Message<OrderRequest> message)
    {
        OrderRequest order = message.body();
        System.out.println("[order.created] Received: " + order);
        return "Accepted: " + order.getId();
    }

    /**
     * Handles order completion events. Fire-and-forget (void return, no reply).
     */
    @VertxEventDefinition("order.completed")
    public void handleOrderCompleted(Message<String> message)
    {
        System.out.println("[order.completed] Order completed: " + message.body());
    }

    /**
     * Handles order cancellation. Returns a confirmation string.
     */
    @VertxEventDefinition(value = "order.cancelled",
            options = @VertxEventOptions(worker = true))
    public String handleOrderCancelled(Message<String> message)
    {
        System.out.println("[order.cancelled] Cancelling order: " + message.body());
        return "Cancelled: " + message.body();
    }
}
