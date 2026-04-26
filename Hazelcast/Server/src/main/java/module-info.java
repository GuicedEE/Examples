module com.guicedee.examples.hazelcast.server {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx;
	requires com.guicedee.guicedhazelcast;

	exports com.guicedee.examples.hazelcast.server;
	opens com.guicedee.examples.hazelcast.server to com.google.guice;
}