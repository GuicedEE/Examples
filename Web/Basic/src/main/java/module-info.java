module com.guicedee.examples.web.basic {
	requires transitive com.guicedee.vertx.web;

	exports com.guicedee.examples.web.basic;
	opens com.guicedee.examples.web.basic to com.google.guice;
}