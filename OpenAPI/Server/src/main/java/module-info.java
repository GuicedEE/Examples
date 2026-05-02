module com.guicedee.examples.openapi.server {
	requires transitive com.guicedee.rest;
	requires transitive com.guicedee.openapi;

	exports com.guicedee.examples.openapi.server;
	opens com.guicedee.examples.openapi.server to com.google.guice, com.fasterxml.jackson.databind, com.guicedee.rest;
}