module com.guicedee.examples.persistence.cassandra {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.persistence;
	requires io.vertx.cassandra.client;

	exports com.guicedee.examples.persistence.cassandra;
	opens com.guicedee.examples.persistence.cassandra to com.google.guice;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.cassandra.ExampleCassandraModule;
}

