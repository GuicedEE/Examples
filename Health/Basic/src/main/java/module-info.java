module com.guicedee.examples.health.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.health;

	exports com.guicedee.examples.health.basic;
	opens com.guicedee.examples.health.basic to com.google.guice;
}

