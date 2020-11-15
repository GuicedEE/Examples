package com.guicedee.primefaces.showcase;

import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import com.guicedee.logger.LogFactory;

import java.util.logging.Level;


public class BootPrimefacesExtensionsShowcase
{
	public static void main(String[] args) throws Exception
	{
		int port = 7950;

		GuiceContext.instance().getConfig().setIncludeModuleAndJars(true);

		LogFactory.configureDefaultLogHiding();
		LogFactory.configureConsoleSingleLineOutput(Level.CONFIG);


		GuicedUndertow undertow = new GuicedUndertow();
		undertow.setHttp2(true);
		undertow.setHost("0.0.0.0");
		undertow.setPort(port);
		undertow.bootMe();

		System.out.println("Started");

	}
}
