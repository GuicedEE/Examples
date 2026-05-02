module com.guicedee.examples.jaxws.secured {
	requires transitive com.guicedee.guicedinjection;
	requires transitive jakarta.xml.ws;

	exports com.guicedee.examples.jaxws.secured;
	opens com.guicedee.examples.jaxws.secured to com.google.guice;
}