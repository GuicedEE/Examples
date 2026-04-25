package com.guicedee.examples.telemetry.basic;

import com.guicedee.telemetry.Trace;
import com.guicedee.telemetry.SpanAttribute;

/**
 * Service with @Trace annotations for automatic span creation.
 */
public class TracedService
{
    @Trace("process-order")
    public void processOrder(@SpanAttribute("order.id") String orderId,
                             @SpanAttribute("order.amount") double amount)
    {
        System.out.println("Processing order " + orderId + " for $" + amount);
        validatePayment(orderId);
    }

    @Trace("validate-payment")
    public void validatePayment(@SpanAttribute("order.id") String orderId)
    {
        System.out.println("Validating payment for " + orderId);
    }
}

