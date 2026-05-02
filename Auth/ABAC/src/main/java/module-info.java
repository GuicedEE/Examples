module com.guicedee.examples.auth.abac {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.abac;
	requires transitive io.vertx.auth.jwt;

	exports com.guicedee.examples.auth.abac;
	opens com.guicedee.examples.auth.abac to com.google.guice, com.fasterxml.jackson.databind;
}
