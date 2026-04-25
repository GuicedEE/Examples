module com.guicedee.examples.web.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx.web;

	exports com.guicedee.examples.web.basic;
	opens com.guicedee.examples.web.basic to com.google.guice;
}