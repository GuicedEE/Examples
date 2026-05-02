module com.guicedee.examples.metrics.basic {

	requires transitive com.guicedee.metrics;

	exports com.guicedee.examples.metrics.basic;
	opens com.guicedee.examples.metrics.basic to com.google.guice;
}

