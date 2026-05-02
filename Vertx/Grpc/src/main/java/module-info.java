module com.guicedee.examples.vertx.grpc {
    requires com.guicedee.client;
    requires com.guicedee.vertx;
    requires io.vertx.grpc.server;
    requires io.vertx.grpc.client;
    requires io.vertx.grpc.common;
    requires io.vertx.core;
    requires com.google.guice;
    requires java.logging;

    opens com.guicedee.examples.vertx.grpc to com.google.guice, com.fasterxml.jackson.databind;
    exports com.guicedee.examples.vertx.grpc;

    provides com.guicedee.client.services.lifecycle.IGuiceModule
            with com.guicedee.examples.vertx.grpc.ExampleGrpcModule;
}



