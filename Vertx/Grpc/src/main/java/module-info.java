import com.guicedee.client.services.lifecycle.IGuiceModule;

module com.guicedee.examples.vertx.grpc {
	requires transitive com.guicedee.guicedinjection;
	requires transitive io.vertx.grpc.server;
	requires transitive io.vertx.grpc.client;
	requires transitive io.vertx.grpc.common;

	opens com.guicedee.examples.vertx.grpc to com.google.guice, tools.jackson.databind;
	exports com.guicedee.examples.vertx.grpc;

	provides IGuiceModule
			with com.guicedee.examples.vertx.grpc.ExampleGrpcModule;
}
