module com.guicedee.examples.openapi.server {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.rest;
	requires com.guicedee.openapi;

	exports com.guicedee.examples.openapi.server;
	opens com.guicedee.examples.openapi.server to com.google.guice, com.fasterxml.jackson.databind, com.guicedee.rest;
}