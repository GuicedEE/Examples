module com.guicedee.examples.hazelcast.queues {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx;

	exports com.guicedee.examples.hazelcast.queues;
	opens com.guicedee.examples.hazelcast.queues to com.google.guice;
}