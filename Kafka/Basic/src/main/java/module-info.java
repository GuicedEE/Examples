module com.guicedee.examples.kafka.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.kafka;

	exports com.guicedee.examples.kafka.basic;
	opens com.guicedee.examples.kafka.basic to com.google.guice, com.guicedee.kafka;
}

