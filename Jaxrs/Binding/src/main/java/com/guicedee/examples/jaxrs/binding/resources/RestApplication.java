package com.guicedee.examples.jaxrs.binding.resources;

import com.guicedee.guicedinjection.GuiceContext;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;


public class RestApplication extends Application
{
	private final Set<Class<?>> classes = new HashSet<>();
	private final Set<Object> singletons = new HashSet<>();
	
	@Override
	public Set<Class<?>> getClasses()
	{
		return classes;
	}
	
	@Override
	public Set<Object> getSingletons()
	{
		//If using application way, can register individual services
		singletons.add(GuiceContext.get(HelloResource.class));
		return singletons;
	}
}
