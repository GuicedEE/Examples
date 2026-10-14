package com.guicedee.examples.kafka.basic;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.GuiceApplication;
import com.guicedee.kafka.KafkaTopicPublisher;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Kafka messaging with annotation-driven topics,
 * consumers, and publishers. Requires a running Kafka instance on localhost.
 */
public class KafkaExample
{
    @Inject
    @Named("order-events")
    private KafkaTopicPublisher orderPublisher;

    public static void main(String[] args)
    {
        LocalDateTime startTime = LocalDateTime.now();

        GuiceApplication.run(() -> {
            IGuiceContext.registerModule("com.guicedee.examples.kafka.basic");
            IGuiceContext.getContext().getConfig().setServiceLoadWithClassPath(true);
        });

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Kafka example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        KafkaExample example = IGuiceContext.get(KafkaExample.class);
        example.orderPublisher.send("order-key", "{\"orderId\":\"ORD-001\",\"item\":\"Widget\"}");

        System.out.println("Published order event to Kafka");
    }
}

