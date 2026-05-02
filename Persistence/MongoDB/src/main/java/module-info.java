module com.guicedee.examples.persistence.mongodb {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.persistence;
	requires io.vertx.mongo.client;

	exports com.guicedee.examples.persistence.mongodb;
	opens com.guicedee.examples.persistence.mongodb to com.google.guice;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.mongodb.ExampleMongoModule;
}

