module com.guicedee.examples.hazelcast.client {

	requires transitive com.guicedee.guicedhazelcast;

	exports com.guicedee.examples.hazelcast.client;
	opens com.guicedee.examples.hazelcast.client to com.google.guice;
}