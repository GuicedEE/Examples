module com.guicedee.examples.jwt.basic {
	requires transitive com.guicedee.guicedinjection;
	requires transitive com.guicedee.microprofile.jwt;
	requires transitive io.vertx.auth.jwt;

	exports com.guicedee.examples.jwt.basic;
	opens com.guicedee.examples.jwt.basic to com.google.guice;
}
