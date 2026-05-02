module com.guicedee.examples.auth.ldap {
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.ldap;

	exports com.guicedee.examples.auth.ldap;
	opens com.guicedee.examples.auth.ldap to com.google.guice, com.fasterxml.jackson.databind;
}
