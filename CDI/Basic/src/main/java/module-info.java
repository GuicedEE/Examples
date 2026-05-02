module com.guicedee.examples.cdi.basic {
	requires transitive com.guicedee.guicedinjection;

	exports com.guicedee.examples.cdi.basic;
	opens com.guicedee.examples.cdi.basic to com.google.guice;
}
