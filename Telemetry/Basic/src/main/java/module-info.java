module com.guicedee.examples.telemetry.basic {
	requires transitive com.guicedee.guicedinjection;
	requires transitive com.guicedee.telemetry;

	exports com.guicedee.examples.telemetry.basic;
	opens com.guicedee.examples.telemetry.basic to com.google.guice;
}

