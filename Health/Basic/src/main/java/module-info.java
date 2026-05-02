module com.guicedee.examples.health.basic {
	requires transitive com.guicedee.health;

	exports com.guicedee.examples.health.basic;
	opens com.guicedee.examples.health.basic to com.google.guice;
}
