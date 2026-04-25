module com.guicedee.examples.vertx.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx;

	exports com.guicedee.examples.vertx.basic;
	opens com.guicedee.examples.vertx.basic to com.google.guice, com.guicedee.vertx, com.fasterxml.jackson.databind;
}

