package com.guicedee.examples.jaxrs.basic.tests;

import com.guicedee.examples.jaxrs.basic.HelloWorld;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest
{
	@Test
	public void testWorld() throws Exception
	{
		HelloWorld.main(null);
		
		HttpClient client = HttpClient.newBuilder()
						.connectTimeout(Duration.of(5, ChronoUnit.SECONDS))
						.build();
		HttpResponse response = client.send(HttpRequest.newBuilder()
										.GET()
										.uri(new URI("http://localhost:6003/rest/hello/world"))
										.build(),
						HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		assertEquals(200, response.statusCode());
	}
}