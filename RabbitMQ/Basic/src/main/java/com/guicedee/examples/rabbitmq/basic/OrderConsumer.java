package com.guicedee.examples.rabbitmq.basic;

import com.guicedee.rabbit.QueueConsumer;
import com.guicedee.rabbit.QueueDefinition;
import io.vertx.rabbitmq.RabbitMQMessage;

/**
 * Consumes messages from the "order-events" queue.
 * Discovered automatically via ClassGraph.
 */
@QueueDefinition("order-events")
public class OrderConsumer implements QueueConsumer
{
    @Override
    public void consume(RabbitMQMessage message)
    {
        System.out.println("Received order event: " + message.body());
    }
}

