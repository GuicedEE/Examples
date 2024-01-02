module com.guicedee.examples.jaxrs.basic {
	requires com.guicedee.guicedservlets.rest;
	requires com.guicedee.guicedservlets.undertow;
	
	requires java.net.http;
	requires jakarta.ws.rs;
	requires com.google.guice;
	requires com.guicedee.guicedinjection;

	exports com.guicedee.examples.jaxrs.basic;
	opens com.guicedee.examples.jaxrs.basic to com.google.guice, com.fasterxml.jackson.databind, org.apache.cxf;
}
