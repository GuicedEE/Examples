package com.guicedee.examples.metrics.basic;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

/**
 * Service demonstrating @Counted and @Timed metrics.
 * Metrics are automatically collected via Guice AOP interceptors.
 */
public class OrderService
{
    @Counted(name = "orders-placed", description = "Number of orders placed")
    public String placeOrder(String item)
    {
        return "Order placed for: " + item;
    }

    @Timed(name = "order-processing-time", description = "Time to process an order")
    public String processOrder(String orderId)
    {
        // Simulate processing
        try
        {
            Thread.sleep(50);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
        return "Processed order: " + orderId;
    }
}

