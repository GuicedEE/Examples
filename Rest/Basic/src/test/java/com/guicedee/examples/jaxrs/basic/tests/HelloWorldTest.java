package com.guicedee.examples.jaxrs.basic.tests;

import com.guicedee.client.IGuiceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest
{
	@Test
	public void testWorld() throws Exception
	{
        System.setProperty("HTTP_ENABLED", "true");
        System.setProperty("HTTP_PORT", "6003");
        IGuiceContext.registerModule("com.guicedee.examples.jaxrs.basic");
        var context = IGuiceContext.instance();
        context.getConfig().setServiceLoadWithClassPath(true);
        context.inject();
        context.getLoadingFinished().toCompletionStage().toCompletableFuture().get(30, TimeUnit.SECONDS);
		
		HttpClient client = HttpClient.newBuilder()
						.connectTimeout(Duration.of(5, ChronoUnit.SECONDS))
						.build();
		HttpResponse response = client.send(HttpRequest.newBuilder()
										.GET()
										.uri(new URI("http://localhost:6003/hello/world"))
										.build(),
						HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		assertEquals(200, response.statusCode());
		
	}

    @AfterEach
    void shutdown() {
        IGuiceContext.instance().destroy();
    }
}
