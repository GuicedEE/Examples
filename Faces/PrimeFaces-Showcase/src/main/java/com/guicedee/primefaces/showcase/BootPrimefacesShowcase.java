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
		LogFactory.configureDefaultLogHiding();

		LogFactory.setGroupLevel("javax.faces", Level.CONFIG);
		LogFactory.setGroupLevel("jakarta.faces", Level.CONFIG);

		GuicedUndertow undertow = new GuicedUndertow();
		undertow.setHttp2(true);
		undertow.setHost("0.0.0.0");
		undertow.setPort(port);ta
		undertow.bootMe();
		System.out.println("Started");
	}
}
