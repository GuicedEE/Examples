import com.guicedee.examples.jaxrs.binding.RestBinding;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;

module com.guicedee.examples.jaxrs.binding {
	requires com.guicedee.guicedservlets.rest;
	requires com.guicedee.guicedservlets.undertow;
	
	requires java.net.http;
	requires jakarta.ws.rs;

	provides IGuiceModule with RestBinding;

	opens com.guicedee.examples.jaxrs.binding.resources to com.google.guice, com.fasterxml.jackson.databind, org.apache.cxf;
}
