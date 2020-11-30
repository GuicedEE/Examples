import com.guicedee.primefaces.showcase.implementations.ShowcaseModuleInclusion;

open module com.guicedee.examples.faces.primefaces.showcase {
	requires primefaces;

	requires jakarta.annotation;
	requires java.desktop;
	requires org.json;
	requires org.apache.poi;
	requires com.github.librepdf.openpdf;

	requires undertow.servlet;
	requires jakarta.ws.rs;

	requires com.hazelcast.all;

	requires org.ehcache;

	requires jakarta.faces;
	requires jakarta.servlet.jsp;
	requires jakarta.servlet.jsp.jstl;
	requires jakarta.enterprise.cdi;

	requires jfreechart;
	requires com.guicedee.guicedservlets.undertow;

	provides com.guicedee.guicedservlets.undertow.services.UndertowDeploymentConfigurator with com.guicedee.primefaces.showcase.implementations.ShowcaseDeploymentConfiguration;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with ShowcaseModuleInclusion;
	
}
