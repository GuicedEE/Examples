open module com.guicedee.examples.faces.primefaces.showcase {
	requires primefaces;

	requires java.annotation;
	requires java.desktop;
	requires org.json;
	requires org.apache.poi;
	requires com.github.librepdf.openpdf;

	requires undertow.servlet;

	requires com.hazelcast.all;

	requires org.ehcache;

	requires javax.faces;
	requires javax.servlet.jsp;
	requires javax.servlet.jsp.jstl;
	requires jakarta.enterprise.cdi;

	requires jfreechart;

	provides com.guicedee.guicedservlets.undertow.services.UndertowDeploymentConfigurator with com.guicedee.primefaces.showcase.implementations.ShowcaseDeploymentConfiguration;
}
