module com.guicedee.examples.jaxrs.basic {
	requires transitive com.guicedee.rest;

	requires java.net.http;

	exports com.guicedee.examples.jaxrs.basic;
	opens com.guicedee.examples.jaxrs.basic to com.google.guice, com.fasterxml.jackson.databind, com.guicedee.rest;
}
