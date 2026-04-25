package com.guicedee.examples.inject.basic.services;

import com.google.inject.AbstractModule;
import com.guicedee.client.services.lifecycle.IGuiceModule;
import com.guicedee.examples.inject.basic.DefaultGreeter;
import com.guicedee.examples.inject.basic.Greeter;

/**
 * Guice module that binds application interfaces to implementations.
 * Discovered automatically via SPI (module-info.java provides declaration).
 */
public class AppModule extends AbstractModule implements IGuiceModule<AppModule>
{
    @Override
    protected void configure()
    {
        bind(Greeter.class).to(DefaultGreeter.class);
    }
}

