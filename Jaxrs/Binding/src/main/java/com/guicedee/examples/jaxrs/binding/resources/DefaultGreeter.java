package com.guicedee.examples.jaxrs.binding.resources;

public class DefaultGreeter implements Greeter
{
	public String greet(final String name)
	{
		return "Hello " + name;
	}
}
