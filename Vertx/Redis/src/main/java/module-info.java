module com.guicedee.examples.vertx.redis {
    requires com.guicedee.client;
    requires com.guicedee.vertx;
    requires io.vertx.redis.client;
    requires io.vertx.core;
    requires com.google.guice;
    requires static lombok;
    requires org.apache.logging.log4j;

    opens com.guicedee.examples.vertx.redis to com.google.guice, com.fasterxml.jackson.databind;
    exports com.guicedee.examples.vertx.redis;

    provides com.guicedee.client.services.lifecycle.IGuiceModule
            with com.guicedee.examples.vertx.redis.ExampleRedisModule;
}


