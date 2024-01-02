package com.guicedee.examples.jaxrs.binding.implementations;

import com.google.inject.AbstractModule;
import com.guicedee.examples.jaxrs.binding.resources.DefaultGreeter;
import com.guicedee.examples.jaxrs.binding.resources.Greeter;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;

@SuppressWarnings("PointlessBinding")
public class RestTestBinding
		extends AbstractModule
		implements IGuiceModule<RestTestBinding>
{

	@Override
	protected void configure()
	{
		bind(Greeter.class).to(DefaultGreeter.class);
	}
}
