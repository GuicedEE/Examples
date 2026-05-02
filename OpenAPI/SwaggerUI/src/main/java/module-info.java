module com.guicedee.examples.openapi.swaggerui {
	requires transitive com.guicedee.rest;
	requires transitive com.guicedee.openapi;
	requires transitive com.guicedee.swagger.ui;

	exports com.guicedee.examples.openapi.swaggerui;
	opens com.guicedee.examples.openapi.swaggerui to com.google.guice, com.fasterxml.jackson.databind, com.guicedee.rest;
}