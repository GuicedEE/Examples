package com.guicedee.examples.jaxrs.binding.test;

import com.guicedee.client.IGuiceContext;
import com.guicedee.examples.jaxrs.binding.BootJaxRSBindings;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BootJaxRSBindingsTest
{

    @Test
    public void testRS() throws Exception
    {
        BootJaxRSBindings.main(null);

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
        response = client.send(HttpRequest.newBuilder()
                                          .GET()
                                          .uri(new URI("http://localhost:6003/rest/hello/helloObject/world"))
                                          .build(),
                HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        assertEquals(200, response.statusCode());

        IGuiceContext.instance()
                     .destroy();
    }
}