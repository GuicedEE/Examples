package com.guicedee.examples.jaxrs.basic;

import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("hello")
@Produces("application/json")
public class HelloWorld {
    @GET
    @Path("{name}")
    public String hello(@PathParam("name") final String name) {
        return "Hello! " + name;
    }
    public static void main(String[] args) throws Exception {
        GuiceContext.instance().getConfig().setServiceLoadWithClassPath(true);
        GuicedUndertow.boot("0.0.0.0", 6003);
    }
}
