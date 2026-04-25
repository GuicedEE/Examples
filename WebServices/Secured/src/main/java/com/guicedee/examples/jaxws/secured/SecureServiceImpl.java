package com.guicedee.examples.jaxws.secured;

import jakarta.jws.WebService;

/**
 * Secured SOAP service implementation.
 * In production, add CXF WSS4J interceptors for WS-Security.
 */
@WebService(endpointInterface = "com.guicedee.examples.jaxws.secured.SecureService",
        serviceName = "SecureService",
        portName = "SecurePort",
        targetNamespace = "http://examples.guicedee.com/secure")
public class SecureServiceImpl implements SecureService
{
    @Override
    public String getSecureData(String token)
    {
        if ("valid-token".equals(token))
        {
            return "Secure data payload";
        }
        return "Access denied";
    }
}

