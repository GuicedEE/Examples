package com.guicedee.examples.jaxrs.binding;


import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.rest.RESTContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import io.undertow.Undertow;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BootJaxRSBasic
{
	public static void main(String... args) throws Exception
	{
		GuiceContext.registerModule("com.guicedee.examples.jaxrs.basic");
		Undertow undertow = GuicedUndertow.boot("0.0.0.0", 6003);
	}
}
