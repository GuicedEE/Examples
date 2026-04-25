module com.guicedee.examples.hazelcast.server {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx;

	exports com.guicedee.examples.hazelcast.server;
	opens com.guicedee.examples.hazelcast.server to com.google.guice;
}