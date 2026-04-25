module com.guicedee.examples.jaxws.secured {
	requires com.guicedee.guicedinjection;
	requires jakarta.xml.ws;

	exports com.guicedee.examples.jaxws.secured;
	opens com.guicedee.examples.jaxws.secured to com.google.guice;
}