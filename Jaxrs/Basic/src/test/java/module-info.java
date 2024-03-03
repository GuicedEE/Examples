module com.guicedee.examples.jaxrs.basic.test {
	requires com.guicedee.examples.jaxrs.basic;
	requires org.junit.jupiter.api;
	
	requires java.net.http;
	
	requires com.guicedee.guicedservlets.rest;
	requires com.guicedee.guicedservlets.undertow;
	requires com.guicedee.guicedinjection;
	
	opens com.guicedee.examples.jaxrs.basic.tests to com.google.guice, com.fasterxml.jackson.databind, org.apache.cxf,org.junit.platform.commons;
}