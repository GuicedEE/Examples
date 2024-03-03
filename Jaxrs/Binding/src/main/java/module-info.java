import com.guicedee.examples.jaxrs.binding.implementations.RestTestBinding;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;

module com.guicedee.examples.jaxrs.binding {
    exports com.guicedee.examples.jaxrs.binding to com.guicedee.examples.jaxrs.binding.test;

    requires com.guicedee.guicedservlets.rest;
    requires com.guicedee.guicedservlets.undertow;
    requires com.guicedee.guicedinjection;

    requires java.net.http;
    requires jakarta.ws.rs;

    provides IGuiceModule with RestTestBinding;

    opens com.guicedee.examples.jaxrs.binding to com.google.guice, com.fasterxml.jackson.databind, org.apache.cxf;
    opens com.guicedee.examples.jaxrs.binding.implementations to com.fasterxml.jackson.databind, com.google.guice, org.apache.cxf;
    opens com.guicedee.examples.jaxrs.binding.resources to com.fasterxml.jackson.databind, com.google.guice, org.apache.cxf;

}
