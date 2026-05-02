module com.guicedee.examples.hazelcast.server {
	requires transitive com.guicedee.guicedhazelcast;

	exports com.guicedee.examples.hazelcast.server;
	opens com.guicedee.examples.hazelcast.server to com.google.guice;
}