import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import com.guicedee.primefaces.showcase.implementations.ShowcaseDeploymentConfiguration;
import com.guicedee.primefaces.showcase.implementations.ShowcaseModuleInclusion;

open module com.guicedee.examples.faces.primefaces.extensions.showcase {

	requires com.guicedee.guicedservlets.primefaces;
	requires org.primefaces.extensions;
	requires jakarta.annotation;
	requires com.github.librepdf.openpdf;
	requires java.desktop;
	requires jakarta.enterprise.cdi;
	requires org.apache.commons.collections4;
	requires org.apache.poi;
	requires org.apache.poi.ooxml;
	requires org.json;

	provides com.guicedee.guicedservlets.undertow.services.UndertowDeploymentConfigurator with ShowcaseDeploymentConfiguration;
	provides IGuiceScanModuleInclusions with ShowcaseModuleInclusion;

}
