module com.guicedee.examples.auth.ldap {
    requires com.guicedee.guicedinjection;
	requires transitive com.guicedee.rest;
	requires transitive io.vertx.auth.ldap;

	exports com.guicedee.examples.auth.ldap;
	opens com.guicedee.examples.auth.ldap to com.google.guice, tools.jackson.databind;
}
