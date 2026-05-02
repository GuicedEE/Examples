module com.guicedee.examples.cerial.basic {
	requires transitive com.guicedee.cerial;

	exports com.guicedee.examples.cerial.basic;
	opens com.guicedee.examples.cerial.basic to com.google.guice;
}

