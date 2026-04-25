@com.guicedee.vertx.Verticle
@com.guicedee.kafka.KafkaConnectionOptions(
        value = "example-connection",
        bootstrapServers = "localhost:9092",
        groupId = "example-group"
)
@com.guicedee.kafka.KafkaTopicCreate(
        value = "order-events",
        partitions = 3,
        replicationFactor = 1
)
package com.guicedee.examples.kafka.basic;

