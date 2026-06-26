module com.guicedee.examples.auth.oauth2 {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.oauth2;

	exports com.guicedee.examples.auth.oauth2;
	opens com.guicedee.examples.auth.oauth2 to com.google.guice, tools.jackson.databind;
}
