module com.guicedee.examples.rabbitmq.basic {
	requires transitive com.guicedee.guicedinjection;
	requires transitive com.guicedee.rabbit;

	exports com.guicedee.examples.rabbitmq.basic;
	opens com.guicedee.examples.rabbitmq.basic to com.google.guice, com.guicedee.rabbit;
}

