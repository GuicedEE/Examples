module com.guicedee.examples.hazelcast.queues {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx;
	requires com.guicedee.guicedhazelcast;

	exports com.guicedee.examples.hazelcast.queues;
	opens com.guicedee.examples.hazelcast.queues to com.google.guice;
}