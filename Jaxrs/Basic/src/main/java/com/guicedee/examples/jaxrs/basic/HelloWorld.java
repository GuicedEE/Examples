package com.guicedee.examples.jaxrs.basic;

import com.guicedee.guicedinjection.*;
import com.guicedee.guicedservlets.undertow.*;
import io.undertow.*;
import jakarta.ws.rs.*;

import java.time.*;
import java.time.temporal.*;

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
		GuiceContext.registerModule("com.guicedee.examples.jaxrs.basic");
		Undertow boot = GuicedUndertow.boot("0.0.0.0", 6003);
		LocalDateTime endTime = LocalDateTime.now();
		
		System.out.println("Started in " + ChronoUnit.MILLIS.between(startTime, endTime) + "ms");
	}
}
