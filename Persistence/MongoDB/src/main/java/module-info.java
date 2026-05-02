module com.guicedee.examples.persistence.mongodb {
	requires transitive com.guicedee.persistence;
	requires transitive io.vertx.mongo.client;

	exports com.guicedee.examples.persistence.mongodb;
	opens com.guicedee.examples.persistence.mongodb to com.google.guice;

	provides com.guicedee.client.services.lifecycle.IGuiceModule
			with com.guicedee.examples.persistence.mongodb.ExampleMongoModule;
}

