package com.guicedee.examples.cdi.basic;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * A CDI-annotated service. The GuicedEE CDI bridge maps @ApplicationScoped to a Guice singleton.
 */
@ApplicationScoped
public class GreetingService
{
    public String greet(String name)
    {
        return "Hello from CDI, " + name + "!";
    }
}

