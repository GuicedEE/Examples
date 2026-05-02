module com.guicedee.examples.persistence.cassandra {
	requires transitive com.guicedee.persistence;
	requires transitive io.vertx.cassandra.client;

	exports com.guicedee.examples.persistence.cassandra;
	opens com.guicedee.examples.persistence.cassandra to com.google.guice;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.cassandra.ExampleCassandraModule;
}
