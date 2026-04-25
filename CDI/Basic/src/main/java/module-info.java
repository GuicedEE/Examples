module com.guicedee.examples.cdi.basic {
	requires com.guicedee.guicedinjection;
	requires jakarta.cdi;
	requires jakarta.inject;

	exports com.guicedee.examples.cdi.basic;
	opens com.guicedee.examples.cdi.basic to com.google.guice;
}

