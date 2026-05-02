module com.guicedee.examples.hazelcast.queues {

	requires transitive com.guicedee.guicedhazelcast;

	exports com.guicedee.examples.hazelcast.queues;
	opens com.guicedee.examples.hazelcast.queues to com.google.guice;
}