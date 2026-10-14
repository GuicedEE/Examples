module com.guicedee.examples.jaxrs.basic {
    requires com.guicedee.guicedinjection;
	requires transitive com.guicedee.rest;

	requires java.net.http;

	exports com.guicedee.examples.jaxrs.basic;
	opens com.guicedee.examples.jaxrs.basic to com.google.guice, tools.jackson.databind, com.guicedee.rest;
}
