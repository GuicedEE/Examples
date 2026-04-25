package com.guicedee.examples.inject.basic.services;

import com.guicedee.client.services.lifecycle.IGuicePostStartup;

/**
 * Runs after the Guice injector is created. Demonstrates the IGuicePostStartup lifecycle hook.
 */
public class PostStartupHook implements IGuicePostStartup<PostStartupHook>
{
    @Override
    public void postLoad()
    {
        System.out.println("[PostStartup] GuicedEE injector is ready!");
    }

    @Override
    public Integer sortOrder()
    {
        return Integer.MAX_VALUE;
    }
}

