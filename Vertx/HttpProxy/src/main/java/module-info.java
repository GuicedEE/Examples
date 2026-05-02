import com.guicedee.client.services.lifecycle.IGuiceModule;

module com.guicedee.examples.vertx.httpproxy {
    requires transitive com.guicedee.vertx;
    requires io.vertx.httpproxy;

    opens com.guicedee.examples.vertx.httpproxy to com.google.guice;

    provides IGuiceModule with com.guicedee.examples.vertx.httpproxy.ExampleProxyModule;
}

