package com.guicedee.examples.jaxrs.basic;

import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
