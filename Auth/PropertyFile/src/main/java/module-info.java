module com.guicedee.examples.auth.properties {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.properties;

	exports com.guicedee.examples.auth.properties;
	opens com.guicedee.examples.auth.properties to com.google.guice, tools.jackson.databind;
}
