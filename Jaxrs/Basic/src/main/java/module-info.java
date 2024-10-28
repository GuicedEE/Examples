module com.guicedee.examples.jaxrs.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.guicedservlets.rest;
	
	requires java.net.http;

    exports com.guicedee.examples.jaxrs.basic;
	opens com.guicedee.examples.jaxrs.basic to com.google.guice, com.fasterxml.jackson.databind, org.apache.cxf;
}
