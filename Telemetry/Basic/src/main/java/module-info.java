module com.guicedee.examples.telemetry.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.telemetry;

	exports com.guicedee.examples.telemetry.basic;
	opens com.guicedee.examples.telemetry.basic to com.google.guice;
}

