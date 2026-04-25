package com.guicedee.examples.jaxws.basic;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

/**
 * Simple SOAP web service interface using JAX-WS annotations.
 */
@WebService(targetNamespace = "http://examples.guicedee.com/hello", name = "HelloService")
public interface HelloService
{
    @WebMethod(operationName = "sayHello")
    @WebResult(name = "greeting")
    String sayHello(@WebParam(name = "name") String name);
}

