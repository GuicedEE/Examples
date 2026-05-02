module com.guicedee.examples.auth.htpasswd {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.htpasswd;

	exports com.guicedee.examples.auth.htpasswd;
	opens com.guicedee.examples.auth.htpasswd to com.google.guice, com.fasterxml.jackson.databind;
}
