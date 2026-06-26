module com.guicedee.examples.vertx.basic {
	requires transitive com.guicedee.guicedinjection;

	exports com.guicedee.examples.vertx.basic;
	opens com.guicedee.examples.vertx.basic to com.google.guice, com.guicedee.vertx, tools.jackson.databind;
}

