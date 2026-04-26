module com.guicedee.examples.jwt.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.microprofile.jwt;
	requires io.vertx.auth.jwt;
	requires io.vertx.core;
	requires io.vertx.auth.common;

	exports com.guicedee.examples.jwt.basic;
	opens com.guicedee.examples.jwt.basic to com.google.guice;
}

