module com.guicedee.examples.openapi.server {
	requires transitive com.guicedee.rest;
	requires transitive com.guicedee.openapi;

	exports com.guicedee.examples.openapi.server;
	opens com.guicedee.examples.openapi.server to com.google.guice, tools.jackson.databind, com.guicedee.rest;
}