module com.guicedee.examples.vertx.auth {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.jwt;
	requires transitive io.vertx.auth.properties;

	exports com.guicedee.examples.vertx.auth;
	opens com.guicedee.examples.vertx.auth to com.google.guice, com.fasterxml.jackson.databind;
}
