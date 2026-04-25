package com.guicedee.examples.inject.basic;

/**
 * Default implementation of {@link Greeter}, bound via {@link com.guicedee.examples.inject.basic.services.AppModule}.
 */
public class DefaultGreeter implements Greeter
{
    @Override
    public String greet(String name)
    {
        return "Hello, " + name + "!";
    }
}

