package com.guicedee.examples.jaxws.basic;

import jakarta.jws.WebService;

/**
 * Implementation of the HelloService SOAP web service.
 */
@WebService(endpointInterface = "com.guicedee.examples.jaxws.basic.HelloService",
        serviceName = "HelloService",
        portName = "HelloPort",
        targetNamespace = "http://examples.guicedee.com/hello")
public class HelloServiceImpl implements HelloService
{
    @Override
    public String sayHello(String name)
    {
        return "Hello, " + name + "!";
    }
}

