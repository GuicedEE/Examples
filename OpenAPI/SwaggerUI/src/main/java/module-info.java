module com.guicedee.examples.openapi.swaggerui {
    requires com.guicedee.guicedinjection;
	requires transitive com.guicedee.rest;
	requires transitive com.guicedee.openapi;
	requires transitive com.guicedee.swaggerui;

	exports com.guicedee.examples.openapi.swaggerui;
	opens com.guicedee.examples.openapi.swaggerui to com.google.guice, tools.jackson.databind, com.guicedee.rest;
}