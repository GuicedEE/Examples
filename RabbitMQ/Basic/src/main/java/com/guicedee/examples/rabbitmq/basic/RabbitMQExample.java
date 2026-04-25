package com.guicedee.examples.rabbitmq.basic;

import com.guicedee.client.IGuiceContext;
import com.guicedee.rabbit.QueuePublisher;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates RabbitMQ messaging with annotation-driven exchanges, queues,
 * consumers, and publishers. Requires a running RabbitMQ instance on localhost.
 */
public class RabbitMQExample
{
    @Inject
    @Named("order-events")
    private QueuePublisher orderPublisher;

    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.rabbitmq.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("RabbitMQ example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        RabbitMQExample example = IGuiceContext.get(RabbitMQExample.class);
        example.orderPublisher.publish("{\"orderId\":\"ORD-001\",\"item\":\"Widget\"}");

        System.out.println("Published order event to RabbitMQ");
    }
}

