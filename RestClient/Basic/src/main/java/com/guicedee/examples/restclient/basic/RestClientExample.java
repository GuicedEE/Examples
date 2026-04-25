package com.guicedee.examples.restclient.basic;

import com.guicedee.client.IGuiceContext;
import com.guicedee.restclient.Endpoint;
import com.guicedee.restclient.RestClient;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates the annotation-driven REST client using @Endpoint and RestClient.
 * Calls an external API using the Vert.x WebClient under the hood.
 */
public class RestClientExample
{
    @Endpoint(url = "https://jsonplaceholder.typicode.com/posts/1", method = "GET")
    @Named("get-post")
    private RestClient<Void, PostResponse> getPostClient;

    public static void main(String[] args)
    {
        System.setProperty("HTTP_ENABLED", "true");

        LocalDateTime startTime = LocalDateTime.now();

        IGuiceContext.registerModule("com.guicedee.examples.restclient.basic");
        IGuiceContext.instance()
                .inject();

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("REST Client example started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");

        RestClientExample example = IGuiceContext.get(RestClientExample.class);
        example.getPostClient.send()
                .subscribe()
                .with(
                        response -> System.out.println("Received: " + response),
                        error -> System.err.println("Error: " + error.getMessage())
                );
    }
}

