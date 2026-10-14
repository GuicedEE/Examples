module com.guicedee.examples.auth.jwt {
    requires com.guicedee.guicedinjection;
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.jwt;

	exports com.guicedee.examples.auth.jwt;
	opens com.guicedee.examples.auth.jwt to com.google.guice, tools.jackson.databind;
}

