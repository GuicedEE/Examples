module com.guicedee.examples.auth.htdigest {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.htdigest;

	exports com.guicedee.examples.auth.htdigest;
	opens com.guicedee.examples.auth.htdigest to com.google.guice, com.fasterxml.jackson.databind;
}
