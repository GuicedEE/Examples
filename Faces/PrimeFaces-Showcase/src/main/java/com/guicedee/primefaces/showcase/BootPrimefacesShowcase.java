package com.guicedee.primefaces.showcase;

import com.google.inject.Key;
import com.google.inject.name.Names;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import com.guicedee.logger.LogFactory;
import io.github.classgraph.ClassGraph;
import org.primefaces.showcase.view.app.GuestPreferences;

import java.util.logging.Level;

public class BootPrimefacesShowcase
{
	public static void main(String[] args) throws Exception
	{
		int port = 7950;

		GuiceContext.instance().getConfig().setIncludeModuleAndJars(true);

		LogFactory.setGroupLevel("javax.faces", Level.CONFIG);
		LogFactory.setGroupLevel("jakarta.faces", Level.CONFIG);
		LogFactory.setGroupLevel("javax.enterprise.resource.webcontainer.jsf.application", Level.CONFIG);
		LogFactory.setGroupLevel("jakarta.enterprise.resource.webcontainer.jsf.application", Level.CONFIG);
		LogFactory.setGroupLevel("javax.enterprise.resource.webcontainer.jsf.config", Level.CONFIG);
		LogFactory.configureDefaultLogHiding();
		LogFactory.configureConsoleSingleLineOutput(Level.CONFIG);


		GuicedUndertow undertow = new GuicedUndertow();
		undertow.setHttp2(true);
		undertow.setHost("0.0.0.0");
		undertow.setPort(port);
		undertow.bootMe();
		System.out.println("Started");

		Object o =GuiceContext.get(GuestPreferences.class);

		System.out.println("asdfasdf - " + o);
	}
}
