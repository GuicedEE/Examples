package com.guicedee.examples.jaxws.secured;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

/**
 * Secured SOAP web service interface. WS-Security (WSS4J) can be configured
 * via CXF interceptors for authentication and message-level encryption.
 */
@WebService(targetNamespace = "http://examples.guicedee.com/secure", name = "SecureService")
public interface SecureService
{
    @WebMethod(operationName = "getSecureData")
    @WebResult(name = "data")
    String getSecureData(@WebParam(name = "token") String token);
}

