package com.guicedee.examples.ibmmq.basic;

import com.guicedee.client.IGuiceContext;
import com.guicedee.ibmmq.IBMMQPublisher;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates IBM MQ messaging with annotation-driven queues,
 * consumers, and publishers. Requires a running IBM MQ instance.
 */
public class IBMMQExample
{
    @Inject
    @Named("DEV.QUEUE.1")
    private IBMMQPublisher orderPublisher;

    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.ibmmq.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("IBM MQ example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        IBMMQExample example = IGuiceContext.get(IBMMQExample.class);
        example.orderPublisher.publish("{\"orderId\":\"ORD-001\",\"item\":\"Widget\"}");

        System.out.println("Published order event to IBM MQ");
    }
}

