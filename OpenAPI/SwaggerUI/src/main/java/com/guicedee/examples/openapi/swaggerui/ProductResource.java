package com.guicedee.examples.openapi.swaggerui;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * Sample REST resource. The Swagger UI will display this at /swagger/.
 */
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource
{
    @GET
    public List<ProductResponse> listProducts()
    {
        return List.of(
                new ProductResponse(1L, "Widget", 9.99),
                new ProductResponse(2L, "Gadget", 19.99)
        );
    }
}
