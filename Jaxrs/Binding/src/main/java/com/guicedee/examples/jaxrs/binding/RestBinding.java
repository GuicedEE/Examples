package com.guicedee.examples.jaxrs.binding;

import com.google.inject.AbstractModule;
import com.guicedee.examples.jaxrs.binding.resources.DefaultGreeter;
import com.guicedee.examples.jaxrs.binding.resources.Greeter;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;

@SuppressWarnings("PointlessBinding")
public class RestBinding
		extends AbstractModule
		implements IGuiceModule<RestBinding>
{

	@Override
	protected void configure()
	{
		bind(Greeter.class).to(DefaultGreeter.class);
	}
}
