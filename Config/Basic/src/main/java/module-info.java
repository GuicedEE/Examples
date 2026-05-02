module com.guicedee.examples.config.basic {
	requires transitive com.guicedee.microprofile.config;

	exports com.guicedee.examples.config.basic;
	opens com.guicedee.examples.config.basic to com.google.guice;
}

