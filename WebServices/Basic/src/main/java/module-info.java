module com.guicedee.examples.jaxws.basic {
	requires transitive com.guicedee.guicedinjection;
	requires transitive jakarta.xml.ws;

	exports com.guicedee.examples.jaxws.basic;
	opens com.guicedee.examples.jaxws.basic to com.google.guice;
}