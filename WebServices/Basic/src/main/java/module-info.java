module com.guicedee.examples.jaxws.basic {
	requires com.guicedee.guicedinjection;
	requires jakarta.xml.ws;

	exports com.guicedee.examples.jaxws.basic;
	opens com.guicedee.examples.jaxws.basic to com.google.guice;
}