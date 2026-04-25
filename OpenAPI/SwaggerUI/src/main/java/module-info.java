module com.guicedee.examples.openapi.swaggerui {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.rest;
	requires com.guicedee.openapi;
	requires com.guicedee.swagger.ui;

	exports com.guicedee.examples.openapi.swaggerui;
	opens com.guicedee.examples.openapi.swaggerui to com.google.guice, com.fasterxml.jackson.databind, com.guicedee.rest;
}