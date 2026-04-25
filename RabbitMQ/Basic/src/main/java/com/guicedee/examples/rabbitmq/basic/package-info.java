@com.guicedee.vertx.Verticle
@com.guicedee.rabbit.RabbitConnectionOptions(
        value = "example-connection",
        host = "localhost",
        user = "guest",
        password = "guest"
)
@com.guicedee.rabbit.QueueExchange(
        value = "example-exchange",
        exchangeType = com.guicedee.rabbit.QueueExchange.ExchangeType.Direct,
        durable = true
)
package com.guicedee.examples.rabbitmq.basic;

