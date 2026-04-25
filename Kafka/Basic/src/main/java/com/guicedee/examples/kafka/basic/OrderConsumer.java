package com.guicedee.examples.kafka.basic;

import com.guicedee.kafka.KafkaTopicConsumer;
import com.guicedee.kafka.KafkaTopicDefinition;
import io.vertx.kafka.client.consumer.KafkaConsumerRecord;

/**
 * Consumes messages from the "order-events" topic.
 * Discovered automatically via ClassGraph.
 */
@KafkaTopicDefinition("order-events")
public class OrderConsumer implements KafkaTopicConsumer<String, String>
{
    @Override
    public void consume(KafkaConsumerRecord<String, String> record)
    {
        System.out.println("Received order event: " + record.value());
    }
}

