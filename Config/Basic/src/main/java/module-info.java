module com.guicedee.examples.config.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.microprofile.config;

	exports com.guicedee.examples.config.basic;
	opens com.guicedee.examples.config.basic to com.google.guice;
}

