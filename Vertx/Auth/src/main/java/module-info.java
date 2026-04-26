module com.guicedee.examples.vertx.auth {
    requires com.guicedee.guicedinjection;
    requires com.guicedee.vertx;
    requires com.guicedee.vertx.web;
    requires com.guicedee.vertx.rest;

    requires io.vertx.auth.jwt;
    requires io.vertx.auth.properties;

    exports com.guicedee.examples.vertx.auth;
    opens com.guicedee.examples.vertx.auth to com.google.guice, com.guicedee.vertx,
            com.fasterxml.jackson.databind;
}

