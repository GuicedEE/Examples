import com.guicedee.examples.jaxrs.binding.implementations.RestTestBinding;
import com.guicedee.client.services.lifecycle.IGuiceModule;

module com.guicedee.examples.jaxrs.binding {
	exports com.guicedee.examples.jaxrs.binding to com.guicedee.examples.jaxrs.binding.test;

	requires transitive com.guicedee.rest;

	requires java.net.http;

	provides IGuiceModule with RestTestBinding;

	opens com.guicedee.examples.jaxrs.binding to com.google.guice, tools.jackson.databind, com.guicedee.rest;
	opens com.guicedee.examples.jaxrs.binding.implementations to tools.jackson.databind, com.google.guice, com.guicedee.rest;
	opens com.guicedee.examples.jaxrs.binding.resources to tools.jackson.databind, com.google.guice, com.guicedee.rest;
}
