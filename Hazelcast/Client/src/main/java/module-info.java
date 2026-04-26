module com.guicedee.examples.hazelcast.client {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx;
	requires com.guicedee.guicedhazelcast;

	exports com.guicedee.examples.hazelcast.client;
	opens com.guicedee.examples.hazelcast.client to com.google.guice;
}