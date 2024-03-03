package com.guicedee.examples.jaxrs.binding;


import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.undertow.GuicedUndertow;
import io.undertow.Undertow;

public class BootJaxRSBindings
{
    public static void main(String... args) throws Exception
    {
        IGuiceContext.registerModule("com.guicedee.examples.jaxrs.binding");
        Undertow undertow = GuicedUndertow.boot("0.0.0.0", 6003);
    }
}
