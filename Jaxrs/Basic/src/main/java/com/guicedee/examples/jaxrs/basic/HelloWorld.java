package com.guicedee.examples.jaxrs.basic;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import io.undertow.Undertow;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Path("hello")
@Produces("application/json")
public class HelloWorld
{
    @GET
    @Path("{name}")
    public String hello(@PathParam("name") final String name)
    {
        return "Hello! " + name;
    }

    public static void main(String[] args) throws Exception
    {
        LocalDateTime startTime = LocalDateTime.now();

        //optional for class scanning optimization
        IGuiceContext.registerModule("com.guicedee.examples.jaxrs.basic");
        Undertow boot = GuicedUndertow.boot("0.0.0.0", 6003);
        LocalDateTime endTime = LocalDateTime.now();

        System.out.println("Started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
    }
}
