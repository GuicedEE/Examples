module com.guicedee.examples.kafka.basic {
	requires transitive com.guicedee.guicedinjection;
	requires transitive com.guicedee.kafka;

	exports com.guicedee.examples.kafka.basic;
	opens com.guicedee.examples.kafka.basic to com.google.guice, com.guicedee.kafka;
}

