package com.guicedee.primefaces.showcase;

import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import com.guicedee.logger.LogFactory;

import java.util.logging.Level;

public class BootPrimefacesShowcase
{
	public static void main(String[] args) throws Exception
	{
		int port = 7950;

		LogFactory.configureConsoleSingleLineOutput(Level.FINER);

		GuicedUndertow undertow = new GuicedUndertow();
		undertow.setHttp2(true);
		undertow.setHost("0.0.0.0");
		undertow.setPort(port);
		undertow.bootMe();
		System.out.println("Started");
	}
}
